package com.roker.template.model.vo;

import com.roker.template.model.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Roker
 * @Date 2020/10/28 16:09
 * @Title UserVO
 * @Description 用户 ＶＯ
 */

@Data
public class UserVO extends BaseVO<User,UserVO>  implements Serializable {

    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户名
     */
    private String username;

    /**
     * 生日
     */
    private Date birthday;


    /**
     * 通过 Entity 获取具体实体类VO
     *
     * @return T
     */
    @Override
    public UserVO buildVO(User user) {
        BeanUtils.copyProperties(user,this);
        return this;
    }
}
