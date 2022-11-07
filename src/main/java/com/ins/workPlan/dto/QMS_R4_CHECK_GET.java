package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class QMS_R4_CHECK_GET {
  private int seq;
  private String qc_item1;
  private String qc_item2;
  private String qc_item3;
  private String qc_item4;
  private double qc_spec1;
  private double qc_spec2;
  private String result_type;
  private String result_type_name;
  private double qc_value1;
  private double qc_value2;
  private String qc_result1;
  private String qc_result2;
  private String qc_result_name;
  private String user_name;
  private String update_date;
}
