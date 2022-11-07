package com.ins.workPlan.dto;

import lombok.Data;

import java.util.List;

@Data
public class OUTS_LIST_GET {
  private String ord_no;
  private String place_name;
  private String end_date;
  private String supp_name;
  private String plan_no;
  private List<OUTS_LIST_GET2> sub;
  private String image1;
  private String keyword;
  private String fire_type;
}
