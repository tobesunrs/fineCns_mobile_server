package com.ins.user.dto;


import lombok.Data;


import java.util.List;


@Data
public class User {
    private String user_code;
    private String user_pwd;
    private String auth_key;
    private String plant_code;
    private String user_code2;
    private String user_name;
    private String message;
    private String result;
    private List<?> msg;

}
