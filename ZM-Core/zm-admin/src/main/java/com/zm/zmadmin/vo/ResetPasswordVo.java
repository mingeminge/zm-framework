package com.zm.zmadmin.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * ==========================
 *
 * @author : yizuomin
 * @date : Created in 20:58 2020/4/26
 * ===========================
 */
@Data
public class ResetPasswordVo {

    private Long id;

    private String username;

    @NotBlank
    @Length(min = 6)
    private String oldPassword;

    @NotBlank
    @Length(min = 6)
    private String newPassword;
}
