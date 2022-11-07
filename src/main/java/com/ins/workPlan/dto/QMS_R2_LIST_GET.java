package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class QMS_R2_LIST_GET {
  private String qc_no;
  private int seq;
  private String qc_item1;
  private String qc_item2;
  private String qc_item3;
  private int qc_spec1;
  private int qc_spec2;
  private String result_type;
  private String value1;
  private String value2;
  private String value3;
}
