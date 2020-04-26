package com.zm.zmadmin.repository;

import com.zm.zmadmin.entity.LoginSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 14:29
 * ==================================
 **/
@Repository
public interface LoginSettingsRepository extends JpaRepository<LoginSettings,Long>, JpaSpecificationExecutor<LoginSettings> {
}
