package com.roker.template.model.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import java.util.Date;

/**
 * @Author Roker
 * @Date 2020/10/27 14:42
 * @Title UserDTO
 * @Description user DTO
 */

@Data
public class UserDTO {


    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    @NotEmpty(message = "昵称不能为为空")
    @Length(min = 1 , max = 10 , message = "昵称长度限制为1~10")
    private String nickname;



    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 1 , max = 16 , message = "用户名长度限制为1~16")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[._~!@#$^&*])[A-Za-z0-9._~!@#$^&*]{8,20}$" , message = "密码不符合规范")
    private String password;

    /**
     * 生日
     */
    @ApiModelProperty("生日")
    @Past(message = "生日时间必须小于当前时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    @Email(message = "邮箱格式有误")
    private String email;
}
