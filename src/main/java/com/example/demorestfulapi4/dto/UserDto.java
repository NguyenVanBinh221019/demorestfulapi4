package com.example.demorestfulapi4.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {
    private Long id;

    @NotEmpty(message = "Thiếu name")
    @Min(value = 10, message = "name phải từ 10 ký tự trở lên.")
    @Max(value = 20, message = "name phải nhỏ hơn 20 ký tự.")
    private String name;
    private int age;
    private String address;
    private String password;
}
