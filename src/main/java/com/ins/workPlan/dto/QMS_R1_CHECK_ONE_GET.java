package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class QMS_R1_CHECK_ONE_GET {
  private int seq;
  private String qc_item1;
  private String qc_item2;
  private String qc_item3;
  private String result_type;
  private String result_type_name;
  private double qc_spec1;
  private double qc_spec2;
  private double qc_value1;
  private double qc_value2;
  private double qc_value3;
  private double qc_value4;
  private double qc_value5;
  private String qc_result1;
  private String qc_result2;
  private String qc_result3;
  private String qc_result4;
  private String qc_result5;
  private String qc_result_name;
  private int qc_qty;
}
