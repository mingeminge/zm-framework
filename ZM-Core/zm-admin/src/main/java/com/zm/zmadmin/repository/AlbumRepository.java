package com.zm.zmadmin.repository;

import com.zm.zmadmin.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 14:28
 * ==================================
 **/
@Repository
public interface AlbumRepository extends JpaRepository<Album,Long>, JpaSpecificationExecutor<Album> {
}
