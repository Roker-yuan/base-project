package com.roker.template.service;

import com.roker.template.model.dto.user.UserDTO;


public interface IUserService {

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    Boolean addUser(UserDTO user);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    Boolean delUser(String id);
}
