package com.zm.zmadmin.repository;

import com.zm.zmadmin.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 14:30
 * ==================================
 **/
@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long>, JpaSpecificationExecutor<Photo> {
}
