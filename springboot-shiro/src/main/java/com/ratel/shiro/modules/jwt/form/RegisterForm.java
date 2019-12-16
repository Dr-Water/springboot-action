

package com.ratel.shiro.modules.jwt.form;


import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 注册表单
 *
 *
 */
@Data
public class RegisterForm {

    @NotBlank(message="手机号不能为空")
    private String mobile;


    @NotBlank(message="密码不能为空")
    private String password;

}
