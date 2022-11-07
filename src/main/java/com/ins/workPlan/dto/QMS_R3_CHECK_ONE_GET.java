package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class QMS_R3_CHECK_ONE_GET {
  private String qc_no;
  private int seq;
  private String qc_item1;
  private String qc_item2;
  private String qc_item3;
  private String result_type;
  private String result_type_name;
  private String result_text;
  private int qc_spec1;
  private int qc_spec2;
  private int qc_value1;
  private int qc_value2;
  private String qc_result1_name;
  private String qc_result2_name;
  private String qc_result_name;
}
