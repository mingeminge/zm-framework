package com.zm.zmadmin.repository;

import com.zm.zmadmin.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 14:27
 * ==================================
 **/
@Repository
public interface AvatarRepository extends JpaRepository<Avatar,Long>, JpaSpecificationExecutor<Avatar> {
}
