package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class SCM_QMS_R1_GET {
  private int seq;
  private String qc_item1;
  private String qc_item2;
  private String qc_item3;
  private String result_type;
  private double qc_spec1;
  private double qc_spec2;
  private int qc_qty;
  private String result_type_name;
  private String part_name;
}
