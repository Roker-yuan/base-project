package com.roker.template.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roker.template.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
