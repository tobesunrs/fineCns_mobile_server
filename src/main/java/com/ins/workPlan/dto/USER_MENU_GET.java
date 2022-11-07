package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class USER_MENU_GET {
  private String menu_code;
  private String menu_name;
  private int plan_count;
  private int claim_count;
  private int r1_count;
  private int r2_count;
  private int r3_count;
  private int r4_count;
}
