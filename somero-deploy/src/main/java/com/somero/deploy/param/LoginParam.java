package com.somero.deploy.param;

import com.somero.deploy.utils.JSON;

import javax.validation.constraints.NotBlank;

public class LoginParam {

    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "登录密码不能为空")
    private String password;

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

    @Override
    public String toString() {
        return JSON.toJsonString(this);
    }


}
