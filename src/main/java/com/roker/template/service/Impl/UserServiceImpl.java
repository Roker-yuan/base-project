package com.roker.template.service.Impl;

import com.roker.template.common.utils.dataUtil.ResponseData;
import com.roker.template.model.dto.user.UserDTO;
import com.roker.template.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author Roker
 * @Date 2020/10/27 14:48
 * @Title UserServiceImpl
 * @Description IUserService 实现类
 */

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public ResponseData addUser(UserDTO user) {
        return ResponseData.ok();
    }
}
