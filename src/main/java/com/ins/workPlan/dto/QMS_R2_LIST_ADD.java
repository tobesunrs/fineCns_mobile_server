package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class QMS_R2_LIST_ADD {
  private String qc_no;
  private String plan_no;
  private String line_code;
  private String data_list;
  private String add_status;
  private String user_code;
}
