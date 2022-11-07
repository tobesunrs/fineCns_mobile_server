package com.ins.common.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Files {
    private int seq;
    private String file_name;
    private Date sys_date;
}
