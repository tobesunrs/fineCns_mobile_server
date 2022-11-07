package com.ins.workPlan;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ins.common.dto.Message;
import com.ins.common.dto.Page;
import com.ins.mapper.workPlan.WorkPlanMapper;
import com.ins.workPlan.dto.*;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Service
public class WorkPlanService {

  @Autowired
  private WorkPlanMapper workPlanMapper;

  public JSONObject workPlanGet(Page p) {

    List<List<Object>> datas = workPlanMapper.workPlanGet(p);

    List<INS_PLAN_NAME> list1 = getDataset(datas, 0);
    List<INS_PLAN_STATUS> list2 = getDataset(datas, 1);
    List<INS_PLAN_STATUS_SUB> list3 = getDataset(datas, 2);

    JSONObject j = new JSONObject();
    j.put("list1", list1);
    j.put("list2", list2);
    j.put("list3", list3);

    return j;
  }

  public JSONObject workPlanGet2(Page p) {

    List<List<Object>> datas = workPlanMapper.workPlanGet2(p);

    List<INS_PLAN_NAME> list1 = getDataset(datas, 0);
    List<INS_PLAN_STATUS> list2 = getDataset(datas, 1);
    List<INS_PLAN_STATUS_SUB> list3 = getDataset(datas, 2);
    List<INS_PLAN_TEAM_GET> list4 = getDataset(datas, 3);

    JSONObject j = new JSONObject();
    j.put("list1", list1);
    j.put("list2", list2);
    j.put("list3", list3);
    j.put("list4", list4);

    return j;
  }

  public Message workTeamAdd(Page p) {
    return workPlanMapper.workTeamAdd(p);
  }

  public JSONObject insPlanStatusGet(Page p) {

    List<List<Object>> datas = workPlanMapper.insPlanStatusGet(p);

    List<INS_PLAN_STATUS> list1 = getDataset(datas, 0);
    List<INS_PLAN_STATUS_SUB> list2 = getDataset(datas, 1);

    JSONObject j = new JSONObject();
    j.put("list1", list1);
    j.put("list2", list2);

    return j;
  }

  private <T> List<T> getDataset(List<List<Object>> datasets, int index) {
    return (List<T>) datasets.get(index);
  }

  public Message attendanceAdd(Page p) {
    return workPlanMapper.attendanceAdd(p);
  }

  public List<SCM_ORD> scmOrdGet(Page p) {
    List<SCM_ORD> ord = workPlanMapper.scmOrdGet(p);

    for (SCM_ORD scm_ord : ord) {
      scm_ord.setSub(workPlanMapper.scmSub(scm_ord.getOrd_no()));
    }
    return ord;

  }

  public List<SCM_ORD> scmOrdGet2(Page p) {
    List<SCM_ORD> ord = workPlanMapper.scmOrdGet2(p);

    for (SCM_ORD scm_ord : ord) {
      scm_ord.setSub(workPlanMapper.scmSub2(scm_ord.getOrd_no()));
    }
    return ord;
  }

  public List<SCM_ORD_SUB> scmOrdSubGet(Page p) {
    return workPlanMapper.scmOrdSubGet(p);
  }

  public List<SCM_ORD_SUB> scmOrdSubGet2(Page p) {
    return workPlanMapper.scmOrdSubGet2(p);
  }

  public List<SCM_QC_ITEM> scmQcItemGet(Page p) {
    return workPlanMapper.scmQcItemGet(p);
  }

  public Message insPlanAdd(MultipartFile f1, MultipartFile fi2, MultipartFile f3, MultipartFile f4, MultipartFile f5,
      MultipartFile s1, String ins_no, String list1, String list2, String user_code, String ins_remark) {

    INS_PLAN_ADD ipa = new INS_PLAN_ADD();
    ipa.setFile1(f1);
    ipa.setFile2(fi2);
    ipa.setFile3(f3);
    ipa.setFile4(f4);
    ipa.setFile5(f5);
    ipa.setSign(s1);
    ipa.setIns_no(ins_no);
    ipa.setList1(list1);
    ipa.setList2(list2);
    ipa.setUser_code(user_code);
    ipa.setIns_remark(ins_remark);

    Message m = new Message();
    try {

      String sign = "";
      String file1;
      String file2;
      String file3;
      String file4;
      String file5;

      File f = new File("D:/UploadFile/sound/insPlan/sign/");
      if (!f.exists()) {
        f.mkdirs();
      }

      File f2 = new File("D:/UploadFile/sound/insPlan/img/");
      if (!f2.exists()) {
        f2.mkdirs();
      }

      MultipartFile file;
      SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");

      Date time = new Date();
      String time1 = format1.format(time);
      char gu5 = (char) 5;

      String keyword = "";
      System.out.println(ipa.getSign());
      if (ipa.getSign() != null) {

        sign = file_add(ipa.getSign(), f, time1, "D:/UploadFile/sound/insPlan/sign/", ipa.getIns_no(), 0);

      }

      if (ipa.getFile1() != null) {
        file1 = file_add(ipa.getFile1(), f2, time1, "D:/UploadFile/sound/insPlan/img/", ipa.getIns_no(), 1);
        keyword = file1 + gu5;
      }

      if (ipa.getFile2() != null) {
        file2 = file_add(ipa.getFile2(), f2, time1, "D:/UploadFile/sound/insPlan/img/", ipa.getIns_no(), 2);
        keyword = keyword + file2 + gu5;
      }

      if (ipa.getFile3() != null) {
        file3 = file_add(ipa.getFile3(), f2, time1, "D:/UploadFile/sound/insPlan/img/", ipa.getIns_no(), 3);
        keyword = keyword + file3 + gu5;
      }

      if (ipa.getFile4() != null) {
        file4 = file_add(ipa.getFile4(), f2, time1, "D:/UploadFile/sound/insPlan/img/", ipa.getIns_no(), 4);
        keyword = keyword + file4 + gu5;
      }

      if (ipa.getFile5() != null) {
        file5 = file_add(ipa.getFile5(), f2, time1, "D:/UploadFile/sound/insPlan/img/", ipa.getIns_no(), 5);
        keyword = keyword + file5 + gu5;
      }

      ipa.setSign_path(sign);
      if (!keyword.equals("")) {
        keyword = keyword.substring(0, keyword.length() - 1);
      }
      ipa.setFile_list(keyword);

      m = workPlanMapper.insPlanAdd(ipa);

      return m;
    } catch (Exception e) {
      e.printStackTrace();
      m.setResult("NG");
      return m;
    }
  }

  public Message R1ImgAdd(@Valid String part_code, @Valid String spec, @Valid MultipartFile f1) {
    R1_IMG_ADD ipa = new R1_IMG_ADD();
    ipa.setPart_code(part_code);
    ipa.setSpec(spec);
    ipa.setFile1(f1);

    Message m = new Message();
    try {
      String file1 = "";

      File f = new File("D:/UploadFile/sound/qmsReport/");
      if (!f.exists()) {
        f.mkdirs();
      }

      MultipartFile file;
      SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");

      Date time = new Date();
      String time1 = format1.format(time);

      String keyword = "";
      System.out.println(ipa.getFile1());
      if (ipa.getFile1() != null) {

        file1 = r1_file_add(ipa.getFile1(), f, time1, "D:/UploadFile/sound/qmsReport/", ipa.getPart_code(),
            ipa.getSpec(), 0);

      }

      ipa.setFile_path(file1);
      if (!keyword.equals("")) {
        keyword = keyword.substring(0, keyword.length() - 1);
      }

      m = workPlanMapper.R1ImgAdd(ipa);

      return m;
    } catch (Exception e) {
      e.printStackTrace();
      m.setResult("NG");
      return m;
    }
  }

  public String file_add(MultipartFile file, File f, String time1, String path, String keyword, int index)
      throws IOException {
    String originalFile = file.getOriginalFilename();

    String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));

    String name = keyword + "_img_" + time1 + "_" + index + originalFileExtension;
    if (index == 0) {
      name = keyword + "_" + time1 + originalFileExtension;
    }
    if (index == 0) {
      f = new File("D:/UploadFile/sound/insPlan/sign/" + name);
    } else {
      f = new File("D:/UploadFile/sound/insPlan/img/" + name);
    }
    // 파일 저장
    file.transferTo(f);
    if (index == 0) {
      return "D:/UploadFile/sound/insPlan/sign/" + name;
    } else {

      return "D:/UploadFile/sound/insPlan/img/" + name;
    }

  }

  public String r1_file_add(MultipartFile file, File f, String time1, String path, String keyword, String keyword2,
      int index)
      throws IOException {
    String originalFile = file.getOriginalFilename();

    String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));

    String name = keyword + "_img_" + time1 + "_" + index + originalFileExtension;
    if (index == 0) {
      name = keyword + "_" + keyword2 + "_" + time1 + originalFileExtension;
    }
    if (index == 0) {
      f = new File("D:/UploadFile/sound/qmsReport/" + name);
    }
    // 파일 저장
    file.transferTo(f);
    if (index == 0) {
      return "D:/UploadFile/sound/qmsReport/" + name;
    } else {
      return "D:/UploadFile/sound/insPlan/img/" + name;
    }

  }

  public String file_add2(MultipartFile file, String time1, String path, String keyword)
      throws IOException {
    String originalFile = file.getOriginalFilename();

    String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));

    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();
    String generatedString = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();

    String name = keyword + "_img_" + time1 + "_" + generatedString + originalFileExtension;

    File f = new File(path + name);

    // 파일 저장
    file.transferTo(f);

    return path + name;

  }

  public List<COMMON_LIST> commonGet(Page p) {
    return workPlanMapper.commonGet(p);
  }

  public List<PLACE_DAY_GET> placeDayGet(Page p) {
    return workPlanMapper.placeDayGet(p);
  }

  public List<INS_EXPENSE_GET> expenseGet(Page p) {
    return workPlanMapper.expenseGet(p);
  }

  public List<INS_BEFORE_IMG> beforeImgGet(Page p) {
    return workPlanMapper.beforeImgGet(p);
  }

  public Message expenseDel(Page p) {

    if (p.getFile_name() != null && !p.getFile_name().equals("")) {
      File file2 = new File(p.getFile_name());
      file2.delete();
    }

    return workPlanMapper.expenseDel(p);
  }

  public Message scmInAdd(Page p) {
    return workPlanMapper.scmInAdd(p);
  }

  public List<SYS_PART_GET> partListGet(Page p) {
    return workPlanMapper.partListGet(p);
  }

  public List<USER_MENU_GET> menuListGet(Page p) {
    return workPlanMapper.menuListGet(p);
  }

  public Message scmOutAdd(Page p) {
    return workPlanMapper.scmOutAdd(p);
  }

  public Message scmRetInAdd(Page p) {
    return workPlanMapper.scmRetInAdd(p);
  }

  public List<OUTS_LIST_GET> outsListGet(Page p) {

    List<OUTS_LIST_GET> outsList = workPlanMapper.outsListGet(p);

    for (OUTS_LIST_GET outs : outsList) {
      outs.setKeyword(p.getKeyword());
      outs.setSub(workPlanMapper.outsListGet2(outs));
      for (OUTS_LIST_GET2 outs2 : outs.getSub()) {
        outs2.setSub2(workPlanMapper.outsListGet3(outs2));
      }
    }

    return outsList;
  }

  public Message outsAdd(Page p) {
    return workPlanMapper.outsAdd(p);
  }

  public List<CLAIM_LIST_GET> claimListGet(Page p) {
    return workPlanMapper.claimListGet(p);
  }

  public Message claimAdd(Page p) {
    return workPlanMapper.claimAdd(p);
  }

  public List<INS_TEA_GET> teamListGet(Page p) {
    return workPlanMapper.teamListGet(p);
  }

  public Message teamChangeAdd(Page p) {
    return workPlanMapper.teamChangeAdd(p);
  }

  public Message claimTeadAdd(Page p) {
    return workPlanMapper.claimTeadAdd(p);
  }

  public List<INS_PLAN_TPM_GET> empListGet(Page p) {
    return workPlanMapper.empListGet(p);
  }

  public JSONObject workPlanCompGet(Page p) {
    List<List<Object>> datas = workPlanMapper.workPlanCompGet(p);

    List<INS_PLAN_NAME> list1 = getDataset(datas, 0);
    List<INS_PLAN_STATUS> list2 = getDataset(datas, 1);
    List<INS_PLAN_STATUS_SUB> list3 = getDataset(datas, 2);
    List<INS_PLAN_TEAM_GET> list4 = getDataset(datas, 3);

    JSONObject j = new JSONObject();
    j.put("list1", list1);
    j.put("list2", list2);
    j.put("list3", list3);
    j.put("list4", list4);

    return j;
  }

  public Message expenseAdd(MultipartFile f1, String keyword, String keyword2, String keyword3, String user_code,
      String work_date, int amount) throws IOException {
    Page p = new Page();
    Message m = new Message();
    p.setKeyword(keyword);
    p.setKeyword2(keyword2);
    p.setKeyword3(keyword3);
    p.setUser_code(user_code);
    p.setAmount(amount);
    p.setWork_date(work_date);

    p.setKeyword4("");
    try {

      File f = new File("D:/UploadFile/sound/insExpense/");
      if (!f.exists()) {
        f.mkdirs();
      }
      SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");

      Date time = new Date();
      String time1 = format1.format(time);

      if (f1 != null) {
        p.setKeyword4(file_add2(f1, time1, "D:/UploadFile/sound/insExpense/", p.getKeyword3()));

      }
      return workPlanMapper.expenseAdd(p);
    } catch (Exception e) {
      e.printStackTrace();
      m.setResult("NG");
      return m;
    }

  }

  // public Message expenseAdd(Page p) {
  // return workPlanMapper.expenseAdd(p);
  // }

  public List<INS_BEFORE_IMG> claimImgGet(Page p) {
    return workPlanMapper.claimImgGet(p);
  }

  public List<WMS_OUT_CRM_GET> wmsOutCrmGet(Page p) {
    return workPlanMapper.wmsOutCrmGet(p);
  }

  public List<WMS_OUT_IMG> wmsOutImgGet(Page p) {
    return workPlanMapper.wmsOutImgGet(p);
  }

  public Message wmsOutAdd(Page p) {
    return workPlanMapper.wmsOutAdd(p);
  }

  public List<INS_IMAGE_GET> insImgGet(Page p) {
    return workPlanMapper.insImgGet(p);
  }

  public List<QMS_R4_GET> qmsR4Get(Page p) {
    return workPlanMapper.qmsR4Get(p);
  }

  public List<QMS_R4_ADD> qmsR4Add(Page p) {
    return workPlanMapper.qmsR4Add(p);
  }

  public List<MB_QMS_OUT_ORD_GET> qmsOutOrdGet(Page p) {
    return workPlanMapper.qmsOutOrdGet(p);
  }

  public List<QMS_OUT_IMG_GET> QmsOutImgGet(Page p) {
    return workPlanMapper.QmsOutImgGet(p);
  }

  public JSONObject QmsOutListGet(Page p) {

    List<List<Object>> datas = workPlanMapper.QmsOutListGet(p);

    List<QMS_OUT_LIST_GET> list1 = getDataset(datas, 0);
    List<QMS_OUT_LIST_GET> list2 = getDataset(datas, 1);

    JSONObject j = new JSONObject();
    j.put("r3_list1", list1);
    j.put("r3_list2", list2);

    return j;
  }

  public List<QMS_R3_ADD> qmsR3Add(Page p) {
    return workPlanMapper.qmsR3Add(p);
  }

  public List<QMS_ROUTE_GET> qmsRoutGet(Page p) {
    return workPlanMapper.qmsRoutGet(p);
  }

  public List<QMS_R2_LIST_GET> qmsR2Get(Page p) {
    return workPlanMapper.qmsR2Get(p);
  }

  public List<QMS_R2_LIST_ADD> qmsR2Add(Page p) {
    return workPlanMapper.qmsR2Add(p);
  }

  public List<PLAN_QTY_GET> planQtyGet(Page p) {
    return workPlanMapper.planQtyGet(p);
  }

  public List<SCM_QMS_ORD_GET> scmQmsOrdGet(Page p) {
    return workPlanMapper.scmQmsOrdGet(p);
  }

  public List<SCM_QMS_R1_GET> scmQmsR1Get(Page p) {
    return workPlanMapper.scmQmsR1Get(p);
  }

  public List<QMS_R1_IMG_GET> qmsR1ImgGet(Page p) {
    return workPlanMapper.qmsR1ImgGet(p);
  }

  public List<QMS_R1_ADD> qmsR1Add(Page p) {
    return workPlanMapper.qmsR1Add(p);
  }

  public List<QMS_R1_CHECK_GET> qmsR1CheckGet(Page p) {
    return workPlanMapper.qmsR1CheckGet(p);
  }

  public List<QMS_R1_CHECK_ONE_GET> qmsR1CheckOneGet(Page p) {
    return workPlanMapper.qmsR1CheckOneGet(p);
  }

  public List<QMS_R1_CHECK_ADD> qmsR1CheckAdd(Page p) {
    return workPlanMapper.qmsR1CheckAdd(p);
  }

  public List<QMS_R2_CHECK_GET> qmsR2CheckGet(Page p) {
    return workPlanMapper.qmsR2CheckGet(p);
  }

  public List<QMS_R2_CHECK_ONE_GET> qmsR2CheckOneGet(Page p) {
    return workPlanMapper.qmsR2CheckOneGet(p);
  }

  public List<QMS_R2_CHECK_ADD> qmsR2CheckAdd(Page p) {
    return workPlanMapper.qmsR2CheckAdd(p);
  }

  public List<QMS_R3_CHECK_GET> qmsR3CheckGet(Page p) {
    return workPlanMapper.qmsR3CheckGet(p);
  }

  public List<QMS_R3_CHECK_ADD> qmsR3CheckAdd(Page p) {
    return workPlanMapper.qmsR3CheckAdd(p);
  }

  public List<QMS_R3_CHECK_ONE_GET> qmsR3CheckOneGet(Page p) {
    return workPlanMapper.qmsR3CheckOneGet(p);
  }

  public List<QMS_R4_CHECK_GET> qmsR4CheckGet(Page p) {
    return workPlanMapper.qmsR4CheckGet(p);
  }

  public List<QMS_R4_CHECK_ADD> qmsR4CheckAdd(Page p) {
    return workPlanMapper.qmsR4CheckAdd(p);
  }
}
