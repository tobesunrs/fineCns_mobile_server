package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class CLAIM_LIST_GET {
  private String claim_no;
  private String place_name;
  private String supp_name;
  private String work_date;
  private String claim_content;
  private String team_status;
  private String emp_name;
  private String emp_tel;
  private String address;
}
