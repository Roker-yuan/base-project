package com.roker.template.controller;

import com.roker.template.common.utils.dataUtil.ResponseData;
import com.roker.template.model.dto.user.UserDTO;
import com.roker.template.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Roker
 * @Date 2020/10/27 11:22
 * @Title UserController
 * @Description 用户 Controller (样例)
 */

@Api(value = "API - UserController", description = "User-接口详情")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    IUserService userService;


    /**
     * 新增 User 信息
     * @param user
     * @return
     */
    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public ResponseData addUser(UserDTO user){
        return userService.addUser(user);
    }

}
