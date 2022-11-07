package com.ins.workPlan.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class INS_PLAN_ADD {
    private String ins_no;
    private String list1; // 계획 char(5) 수량 char(5) 체크
    private String list2; // seq char(5) 체크
    private String user_code;
    private String ins_remark;
    private String file_list;
    private String sign_path;
    private MultipartFile sign;
    private MultipartFile file1;
    private MultipartFile file2;
    private MultipartFile file3;
    private MultipartFile file4;
    private MultipartFile file5;

}
