package com.zm.zmadmin.service;

import com.google.common.collect.Lists;
import com.zm.common.constant.UserConstant;
import com.zm.common.enums.UserEnums;
import com.zm.common.exception.UserException;
import com.zm.common.utils.Base64Util;
import com.zm.common.utils.BeanUtil;
import com.zm.common.vo.PageResult;
import com.zm.zmadmin.dto.UserDto;
import com.zm.zmadmin.entity.Role;
import com.zm.zmadmin.entity.User;
import com.zm.zmadmin.query.UserQuery;
import com.zm.zmadmin.repository.RoleRepository;
import com.zm.zmadmin.repository.UserRepository;
import com.zm.zmadmin.vo.ResetPasswordVo;
import com.zm.zmadmin.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 14:32
 * ==================================
 **/
@Service
public class UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * @param query 查询条件
     * @return 用户列表
     */
    public PageResult list(UserQuery query) {
        PageRequest pageRequest = PageRequest.of(query.getPage(), query.getLimit());
        Specification<User> specification = getSpecification(query);
        Page<User> pages = userRepository.findAll(specification, pageRequest);
        List<User> collect = pages.get().collect(Collectors.toList());
        List<UserVo> userVoList = BeanUtil.copyList(collect, UserVo.class);
        return PageResult.build(pages.getTotalElements(), userVoList);
    }

    /**
     * @param id 用户id
     * @return 通过id查询
     */
    @Cacheable
    public UserVo findById(Long id) {
        User user = userRepository.getOne(id);
        UserVo userVo = BeanUtil.copyProperties(user, UserVo.class);
        return userVo;
    }

    /**
     * @param userDto
     * @return 新增/修改用户
     */
    @Transactional(rollbackOn = Exception.class)
    public User save(UserDto userDto) {
        User user = BeanUtil.copyProperties(userDto, User.class);
        if (null != user.getId()) {
            user.setUpdateTime(new Date());
        } else {
            user.setStatus(UserConstant.NORMAL);
            user.setCreateTime(new Date());
            String password = Base64Util.getBase64(UserConstant.USER_DEFAULT_PASSWORD);
            user.setPassword(password);
        }
        if (!CollectionUtils.isEmpty(userDto.getRoleIds())) {
            List<Role> roleList = new ArrayList<>();
            userDto.getRoleIds().forEach(roleId -> {
                Optional<Role> byId = roleRepository.findById(roleId);
                byId.ifPresent(roleList::add);
            });
            user.setRoles(roleList);
        }
        return userRepository.save(user);
    }


    /**
     * @param userDto
     * @return 注册用户
     */
    @Transactional(rollbackOn = Exception.class)
    public User register(UserDto userDto) {
        User byPhone = userRepository.findByPhone(userDto.getPhone());
        if (null != byPhone) {
            throw new UserException(UserEnums.PHONE_NUMBER_IS_REGISTERED);
        }
        User user = BeanUtil.copyProperties(userDto, User.class);
        user.setStatus(UserConstant.NORMAL);
        user.setCreateTime(new Date());
        user.setPassword(Base64Util.getBase64(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * @param userDto
     * @return 删除用户
     */
    @Transactional(rollbackOn = Exception.class)
    public User delete(UserDto userDto) {
        Optional<User> byId = userRepository.findById(userDto.getId());
        if (!byId.isPresent()) {
            throw new UserException(UserEnums.USER_NOT_FOUND);
        }
        User user = byId.get();
        user.setStatus(UserConstant.DELETE);
        user.setUpdateTime(new Date());
        return userRepository.save(user);
    }

    /**
     * @param resetPasswordVo
     * @return 重置密码
     */
    @Transactional(rollbackOn = Exception.class)
    public User resetPassword(ResetPasswordVo resetPasswordVo) {
        Optional<User> byId = userRepository.findById(resetPasswordVo.getId());
        if (!byId.isPresent()) {
            throw new UserException(UserEnums.USER_NOT_FOUND);
        }
        User user = byId.get();
        String oldPassword = Base64Util.getFromBase64(user.getPassword());
        if (!resetPasswordVo.getOldPassword().equals(oldPassword)) {
            throw new UserException(UserEnums.PASSWORD_ERROR);
        }
        String newPassword = Base64Util.getBase64(resetPasswordVo.getNewPassword());
        user.setPassword(newPassword);
        user.setUpdateTime(new Date());
        return userRepository.save(user);
    }

    public Specification<User> getSpecification(UserQuery query) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = Lists.newArrayList();
                if (StringUtils.isNotEmpty(query.getPhone())) {
                    predicates.add(criteriaBuilder.like(root.get("phone"), query.getPhone() + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
