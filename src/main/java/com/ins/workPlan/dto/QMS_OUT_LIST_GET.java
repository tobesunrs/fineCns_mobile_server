package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class QMS_OUT_LIST_GET {
  private int seq;
  private String qc_item1;
  private String qc_item2;
  private String qc_item3;
  private String result_type;
  private String result_text;
  private int qc_spec1;
  private int qc_spec2;
  private String value;
}
