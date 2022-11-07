package com.ins.workPlan.dto;

import java.util.List;

import lombok.Data;

@Data
public class SCM_ORD {
  private String ord_no;
  private String supp_name;
  private String work_date;
  private String end_date;
  private String delivery_place;
  private List<SCM_ORD_SUB> sub;
}
