package com.roker.template.service;

import com.roker.template.common.utils.dataUtil.ResponseData;
import com.roker.template.model.dto.user.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface IUserService {

    ResponseData addUser(UserDTO user);
}
