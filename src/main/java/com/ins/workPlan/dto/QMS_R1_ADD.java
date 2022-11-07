package com.ins.workPlan.dto;

import lombok.Data;

@Data
public class QMS_R1_ADD {
  private String ord_no;
  private String part_code;
  private String spec;
  private int qty;
  private String data_list;
  private String user_code;
}
