package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class SYS_PART_GET {
  private String part_code;
  private String part_name;
  private String part_name_code;
  private int qty;
  private String spec;
  private int idx;
}
