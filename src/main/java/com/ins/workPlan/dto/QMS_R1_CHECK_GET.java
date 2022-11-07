package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class QMS_R1_CHECK_GET {
  private String qc_no;
  private String part_code;
  private String spec;
  private String part_name;
  private String work_date;
  private String user_name;
  private String supp_name;
  private int result_count;
}
