package com.ins.workPlan.dto;

import lombok.Data;

import java.util.List;

@Data
public class OUTS_LIST_GET2 {
    private String plan_no;
    private String plan_name;
    private List<OUTS_LIST_GET3> sub2;
}
