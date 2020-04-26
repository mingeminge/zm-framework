package com.zm.zmadmin.repository;

import com.zm.zmadmin.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 14:26
 * ==================================
 **/
@Repository
public interface DeptRepository extends JpaRepository<Dept, Long>, JpaSpecificationExecutor<Dept> {
}
