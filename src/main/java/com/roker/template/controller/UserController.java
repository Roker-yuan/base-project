package com.roker.template.controller;

import com.roker.template.common.enums.BusinessEnum;
import com.roker.template.common.utils.dataUtil.ResponseData;
import com.roker.template.model.dto.user.UserDTO;
import com.roker.template.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseData addUser(@RequestBody @Validated UserDTO user){
        Boolean result = userService.addUser(user);
        if (result){
            return ResponseData.ok();
        }else {
            return ResponseData.failed(BusinessEnum.USER_INFO_ADD_FAIL);
        }
    }

    /**
     * 删除用户
     * @param id 用户编号
     * @return 成功或者失败
     */
    @ApiOperation("删除用户")
    @DeleteMapping("/deleteUser/{id}")
    public ResponseData delUser(@PathVariable("id") String id){
        Boolean result =  userService.delUser(id);
        if (result){
            return ResponseData.ok();
        }else {
            return ResponseData.failed(BusinessEnum.USER_INFO_DELETE_FAIL);
        }

    }

}
