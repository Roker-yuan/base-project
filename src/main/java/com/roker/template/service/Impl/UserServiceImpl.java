package com.roker.template.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roker.template.Mapper.UserMapper;
import com.roker.template.model.dto.user.UserDTO;
import com.roker.template.model.entity.User;
import com.roker.template.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author Roker
 * @Date 2020/10/27 14:48
 * @Title UserServiceImpl
 * @Description IUserService 实现类
 */

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private UserMapper userMapper;

    /**
     * 新增用户
     * @param userDto
     * @return
     */
    @Override
    public Boolean addUser(UserDTO userDto) {
        User user = userDto.buildEntity();
        user.setStatus("0");
        user.setCreateTime(new Date());
        return save(user);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public Boolean delUser(String id) {
        return removeById(id);
    }


}
