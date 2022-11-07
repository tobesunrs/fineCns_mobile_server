package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class SCM_ORD_SUB {
  private String part_name;
  private String part_code;
  private String spec;
  private int ord_qty;
  private int qty;
  private String unit_name;
  private String remark;
  private String part_type_name;
  private String qc_name;
  private String status;
}
