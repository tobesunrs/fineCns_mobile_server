package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class INS_EXPENSE_GET {
  private int seq;
  private int amount;
  private String code_name1;
  private String remark;
  private String file_name;
}
