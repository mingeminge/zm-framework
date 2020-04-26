package com.zm.zmadmin.controller;

import com.zm.common.vo.PageResult;
import com.zm.common.vo.Result;
import com.zm.zmadmin.dto.UserDto;
import com.zm.zmadmin.entity.User;
import com.zm.zmadmin.query.UserQuery;
import com.zm.zmadmin.service.UserService;
import com.zm.zmadmin.vo.ResetPasswordVo;
import com.zm.zmadmin.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 15:14
 * ==================================
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public PageResult list(UserQuery userQuery) {
        return userService.list(userQuery);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        UserVo user = userService.findById(id);
        if (null != user) {
            return Result.ok(user);
        }
        return Result.error();
    }

    @PostMapping("/register")
    public Result register(UserDto userDto) {
        User user = userService.register(userDto);
        if (null != user) {
            return Result.ok();
        }
        return Result.error();
    }

    @PostMapping("/save")
    public Result save(UserDto userDto) {
        User save = userService.save(userDto);
        if (null != save) {
            return Result.ok();
        }
        return Result.error();
    }

    @PostMapping("/delete")
    public Result delete(UserDto userDto) {
        User user = userService.delete(userDto);
        if (null != user) {
            return Result.ok();
        }
        return Result.error();
    }

    @PostMapping("/resetPassword")
    public Result resetPassword(ResetPasswordVo resetPasswordVo){
        User user = userService.resetPassword(resetPasswordVo);
        if (null != user) {
            return Result.ok();
        }
        return Result.error();
    }
}
