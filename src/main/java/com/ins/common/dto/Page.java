package com.ins.common.dto;

import lombok.Data;

import java.util.List;

@Data
public class Page {
    private String keyword;
    private String keyword2;
    private String keyword3;
    private String keyword4;
    private String keyword5;
    private String keyword6;
    private String user_code;
    private int seq;
    private int page;
    private int start_row;
    private int rows;
    private String work_date;
    private String plan_date;
    private List<?> allList;
    private String allList2;
    private String plant_code;
    private String file_name;
    private Object sendObject;
    private int work_time;
    private int early_time;
    private int over_time;
    private int week_time;
    private int amount;
}
