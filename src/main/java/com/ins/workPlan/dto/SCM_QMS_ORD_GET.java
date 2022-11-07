package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class SCM_QMS_ORD_GET {
  private String ord_no;
  private String part_code;
  private int ord_qty;
  private String part_name;
  private String spec;
  private String part_type;
  private String part_type_name;
}
