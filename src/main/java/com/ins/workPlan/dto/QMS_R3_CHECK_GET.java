package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class QMS_R3_CHECK_GET {
  private String qc_no;
  private String plan_no;
  private String place_name;
  private String work_date;
  private String r3_grp_name;
  private String qc_result_name;
  private String user_name;
}
