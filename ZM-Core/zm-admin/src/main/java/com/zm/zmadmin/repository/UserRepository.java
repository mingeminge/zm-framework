package com.zm.zmadmin.repository;

import com.zm.zmadmin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 14:25
 * ==================================
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUsername(@Param("username")String username);

    User findByPhone(@Param("phone")String phone);
}
