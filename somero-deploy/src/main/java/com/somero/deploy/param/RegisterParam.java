package com.somero.deploy.param;

import com.somero.deploy.utils.JSON;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class RegisterParam {

    @Length(min = 3, max = 255, message = "用户名格式不正确,最小长度不低于3位")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Length(min = 6, max = 18, message = "密码由6~18位数字和字母组成")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Pattern(regexp = "^1\\d{10}$", message = "手机号格式不正确")
    @NotBlank(message = "手机号码不能为空")
    private String mobile;

    @Email
    private String mail;

    private String realName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return JSON.toJsonString(this);
    }
}
