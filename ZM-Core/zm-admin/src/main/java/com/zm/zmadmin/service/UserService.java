package com.zm.zmadmin.service;

import com.google.common.collect.Lists;
import com.zm.common.vo.PageResult;
import com.zm.zmadmin.entity.User;
import com.zm.zmadmin.query.UserQuery;
import com.zm.zmadmin.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

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

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param query 查询条件
     * @return 用户列表
     */
    public PageResult<User> list(UserQuery query) {
        PageRequest pageRequest = PageRequest.of(query.getPage(), query.getLimit());
        Specification<User> specification = getSpecification(query);
        Page<User> pages = userRepository.findAll(specification, pageRequest);
        return PageResult.build(pages.getTotalElements(), pages.get());
    }

    /**
     * @param id 用户id
     * @return 通过id查询
     */
    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    public User save(User user) {
        user.setCreateTime(new Date());
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
