package com.vip.zn.fitness_system.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @ClassName LoginDto
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/17 11:09
 */

@Data
public class LoginDto implements Serializable {
    @NotBlank(message = "昵称不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;
}
