package com.ins.workPlan.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class R1_IMG_ADD {
  private String part_code;
  private String spec;
  private String file_path;
  private MultipartFile file1;
}
