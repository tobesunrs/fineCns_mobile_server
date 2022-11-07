package com.ins.workPlan;

import java.io.IOException;
import java.util.List;

import com.ins.common.dto.Message;
import com.ins.common.dto.Page;
import com.ins.workPlan.dto.*;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class WorkPlanRestController {

  @Autowired
  private WorkPlanService workPlanService;

  @RequestMapping(value = "/workPlanGet", method = RequestMethod.POST)
  public JSONObject workPlanGet(@RequestBody Page p) {
    return workPlanService.workPlanGet(p);
  }

  @RequestMapping(value = "/workPlanGet2", method = RequestMethod.POST)
  public JSONObject workPlanGet2(@RequestBody Page p) {
    return workPlanService.workPlanGet2(p);
  }

  @RequestMapping(value = "/workPlanCompGet", method = RequestMethod.POST)
  public JSONObject workPlanCompGet(@RequestBody Page p) {
    return workPlanService.workPlanCompGet(p);
  }

  @RequestMapping(value = "/workTeamAdd", method = RequestMethod.POST)
  public Message workTeamAdd(@RequestBody Page p) {
    return workPlanService.workTeamAdd(p);
  }

  @RequestMapping(value = "/insPlanStatusGet", method = RequestMethod.POST)
  public JSONObject insPlanStatusGet(@RequestBody Page p) {
    return workPlanService.insPlanStatusGet(p);
  }

  @RequestMapping(value = "/attendanceAdd", method = RequestMethod.POST)
  public Message attendanceAdd(@RequestBody Page p) {
    return workPlanService.attendanceAdd(p);
  }

  @RequestMapping(value = "/scmOrdGet", method = RequestMethod.POST)
  public List<SCM_ORD> scmOrdGet(@RequestBody Page p) {
    return workPlanService.scmOrdGet(p);
  }

  @RequestMapping(value = "/scmOrdGet2", method = RequestMethod.POST)
  public List<SCM_ORD> scmOrdGet2(@RequestBody Page p) {
    return workPlanService.scmOrdGet2(p);
  }

  @RequestMapping(value = "/scmOrdSubGet", method = RequestMethod.POST)
  public List<SCM_ORD_SUB> scmOrdSubGet(@RequestBody Page p) {
    return workPlanService.scmOrdSubGet(p);
  }

  @RequestMapping(value = "/scmOrdSubGet2", method = RequestMethod.POST)
  public List<SCM_ORD_SUB> scmOrdSubGet2(@RequestBody Page p) {
    return workPlanService.scmOrdSubGet2(p);
  }

  @RequestMapping(value = "/scmQcItemGet", method = RequestMethod.POST)
  public List<SCM_QC_ITEM> scmQcItemGet(@RequestBody Page p) {
    return workPlanService.scmQcItemGet(p);
  }

  @RequestMapping(value = "/insPlanAdd", method = RequestMethod.POST)
  public Message insPlanAdd(
      @Valid @RequestParam(value = "file1", required = false) MultipartFile f1,
      @Valid @RequestParam(value = "file2", required = false) MultipartFile f2,
      @Valid @RequestParam(value = "file3", required = false) MultipartFile f3,
      @Valid @RequestParam(value = "file4", required = false) MultipartFile f4,
      @Valid @RequestParam(value = "file5", required = false) MultipartFile f5,
      @Valid @RequestParam(value = "sign", required = false) MultipartFile s1,
      @Valid @RequestParam("ins_no") String ins_no,
      @Valid @RequestParam("list1") String list1,
      @Valid @RequestParam("list2") String list2,
      @Valid @RequestParam("user_code") String user_code,
      @Valid @RequestParam("ins_remark") String ins_remark

  ) {
    return workPlanService.insPlanAdd(f1, f2, f3, f4, f5, s1, ins_no, list1, list2, user_code, ins_remark);
  }

  @RequestMapping(value = "/R1ImgAdd", method = RequestMethod.POST)
  public Message R1ImgAdd(
      @Valid @RequestParam("part_code") String part_code,
      @Valid @RequestParam("spec") String spec,
      @Valid @RequestParam(value = "file1", required = false) MultipartFile f1

  ) {
    return workPlanService.R1ImgAdd(part_code, spec, f1);
  }

  @RequestMapping(value = "/commonGet", method = RequestMethod.POST)
  public List<COMMON_LIST> commonGet(@RequestBody Page p) {
    return workPlanService.commonGet(p);
  }

  @RequestMapping(value = "/placeDayGet", method = RequestMethod.POST)
  public List<PLACE_DAY_GET> placeDayGet(@RequestBody Page p) {
    return workPlanService.placeDayGet(p);
  }

  @RequestMapping(value = "/expenseAdd", method = RequestMethod.POST)
  public Message expenseAdd(
      @Valid @RequestParam(value = "file_name", required = false) MultipartFile f1,
      @Valid @RequestParam("keyword") String keyword,
      @Valid @RequestParam("keyword2") String keyword2,
      @Valid @RequestParam("keyword3") String keyword3,
      @Valid @RequestParam("user_code") String user_code,
      @Valid @RequestParam("work_date") String work_date,
      @Valid @RequestParam("amount") int amount) throws IOException {

    return workPlanService.expenseAdd(f1, keyword, keyword2, keyword3, user_code, work_date, amount);
  }

  @RequestMapping(value = "/expenseGet", method = RequestMethod.POST)
  public List<INS_EXPENSE_GET> expenseGet(@RequestBody Page p) {
    return workPlanService.expenseGet(p);
  }

  @RequestMapping(value = "/beforeImgGet", method = RequestMethod.POST)
  public List<INS_BEFORE_IMG> beforeImgGet(@RequestBody Page p) {
    return workPlanService.beforeImgGet(p);
  }

  @RequestMapping(value = "/claimImgGet", method = RequestMethod.POST)
  public List<INS_BEFORE_IMG> claimImgGet(@RequestBody Page p) {
    return workPlanService.claimImgGet(p);
  }

  @RequestMapping(value = "/expenseDel", method = RequestMethod.POST)
  public Message expenseDel(@RequestBody Page p) {
    return workPlanService.expenseDel(p);
  }

  @RequestMapping(value = "/scmInAdd", method = RequestMethod.POST)
  public Message scmInAdd(@RequestBody Page p) {
    return workPlanService.scmInAdd(p);
  }

  @RequestMapping(value = "/partListGet", method = RequestMethod.POST)
  public List<SYS_PART_GET> partListGet(@RequestBody Page p) {
    return workPlanService.partListGet(p);
  }

  @RequestMapping(value = "/menuListGet", method = RequestMethod.POST)
  public List<USER_MENU_GET> menuListGet(@RequestBody Page p) {
    return workPlanService.menuListGet(p);
  }

  @RequestMapping(value = "/scmOutAdd", method = RequestMethod.POST)
  public Message scmOutAdd(@RequestBody Page p) {
    return workPlanService.scmOutAdd(p);
  }

  @RequestMapping(value = "/scmRetInAdd", method = RequestMethod.POST)
  public Message scmRetInAdd(@RequestBody Page p) {
    return workPlanService.scmRetInAdd(p);
  }

  @RequestMapping(value = "/outsListGet", method = RequestMethod.POST)
  public List<OUTS_LIST_GET> outsListGet(@RequestBody Page p) {
    return workPlanService.outsListGet(p);
  }

  @RequestMapping(value = "/outsAdd", method = RequestMethod.POST)
  public Message outsAdd(@RequestBody Page p) {
    return workPlanService.outsAdd(p);
  }

  @RequestMapping(value = "/claimListGet", method = RequestMethod.POST)
  public List<CLAIM_LIST_GET> claimListGet(@RequestBody Page p) {
    return workPlanService.claimListGet(p);
  }

  @RequestMapping(value = "/claimAdd", method = RequestMethod.POST)
  public Message claimAdd(@RequestBody Page p) {
    return workPlanService.claimAdd(p);
  }

  @RequestMapping(value = "/teamListGet", method = RequestMethod.POST)
  public List<INS_TEA_GET> teamListGet(@RequestBody Page p) {
    return workPlanService.teamListGet(p);
  }

  @RequestMapping(value = "/teamChangeAdd", method = RequestMethod.POST)
  public Message teamChangeAdd(@RequestBody Page p) {
    return workPlanService.teamChangeAdd(p);
  }

  @RequestMapping(value = "/claimTeadAdd", method = RequestMethod.POST)
  public Message claimTeadAdd(@RequestBody Page p) {
    return workPlanService.claimTeadAdd(p);
  }

  @RequestMapping(value = "/empListGet", method = RequestMethod.POST)
  public List<INS_PLAN_TPM_GET> empListGet(@RequestBody Page p) {
    return workPlanService.empListGet(p);
  }

  @RequestMapping(value = "/wmsOutCrmGet", method = RequestMethod.POST)
  public List<WMS_OUT_CRM_GET> wmsOutCrmGet(@RequestBody Page p) {
    return workPlanService.wmsOutCrmGet(p);
  }

  @RequestMapping(value = "/wmsOutImgGet", method = RequestMethod.POST)
  public List<WMS_OUT_IMG> wmsOutImgGet(@RequestBody Page p) {
    return workPlanService.wmsOutImgGet(p);
  }

  @RequestMapping(value = "/wmsOutAdd", method = RequestMethod.POST)
  public Message wmsOutAdd(@RequestBody Page p) {
    return workPlanService.wmsOutAdd(p);
  }

  @RequestMapping(value = "/insImgGet", method = RequestMethod.POST)
  public List<INS_IMAGE_GET> insImgGet(@RequestBody Page p) {
    return workPlanService.insImgGet(p);
  }

  @RequestMapping(value = "/qmsR4Get", method = RequestMethod.POST)
  public List<QMS_R4_GET> qmsR4Get(@RequestBody Page p) {
    return workPlanService.qmsR4Get(p);
  }

  @RequestMapping(value = "/qmsR4Add", method = RequestMethod.POST)
  public List<QMS_R4_ADD> qmsR4Add(@RequestBody Page p) {
    return workPlanService.qmsR4Add(p);
  }

  @RequestMapping(value = "/qmsOutOrdGet", method = RequestMethod.POST)
  public List<MB_QMS_OUT_ORD_GET> qmsOutOrdGet(@RequestBody Page p) {
    return workPlanService.qmsOutOrdGet(p);
  }

  @RequestMapping(value = "/QmsOutImgGet", method = RequestMethod.POST)
  public List<QMS_OUT_IMG_GET> QmsOutImgGet(@RequestBody Page p) {
    return workPlanService.QmsOutImgGet(p);
  }

  @RequestMapping(value = "/QmsOutListGet", method = RequestMethod.POST)
  public JSONObject QmsOutListGet(@RequestBody Page p) {
    return workPlanService.QmsOutListGet(p);
  }

  @RequestMapping(value = "/qmsR3Add", method = RequestMethod.POST)
  public List<QMS_R3_ADD> qmsR3Add(@RequestBody Page p) {
    return workPlanService.qmsR3Add(p);
  }

  @RequestMapping(value = "/qmsRoutGet", method = RequestMethod.POST)
  public List<QMS_ROUTE_GET> qmsRoutGet(@RequestBody Page p) {
    return workPlanService.qmsRoutGet(p);
  }

  @RequestMapping(value = "/qmsR2Get", method = RequestMethod.POST)
  public List<QMS_R2_LIST_GET> qmsR2Get(@RequestBody Page p) {
    return workPlanService.qmsR2Get(p);
  }

  @RequestMapping(value = "/qmsR2Add", method = RequestMethod.POST)
  public List<QMS_R2_LIST_ADD> qmsR2Add(@RequestBody Page p) {
    return workPlanService.qmsR2Add(p);
  }

  @RequestMapping(value = "/planQtyGet", method = RequestMethod.POST)
  public List<PLAN_QTY_GET> planQtyGet(@RequestBody Page p) {
    return workPlanService.planQtyGet(p);
  }

  @RequestMapping(value = "/scmQmsOrdGet", method = RequestMethod.POST)
  public List<SCM_QMS_ORD_GET> scmQmsOrdGet(@RequestBody Page p) {
    return workPlanService.scmQmsOrdGet(p);
  }

  @RequestMapping(value = "/scmQmsR1Get", method = RequestMethod.POST)
  public List<SCM_QMS_R1_GET> scmQmsR1Get(@RequestBody Page p) {
    return workPlanService.scmQmsR1Get(p);
  }

  @RequestMapping(value = "/qmsR1ImgGet", method = RequestMethod.POST)
  public List<QMS_R1_IMG_GET> qmsR1ImgGet(@RequestBody Page p) {
    return workPlanService.qmsR1ImgGet(p);
  }

  @RequestMapping(value = "/qmsR1Add", method = RequestMethod.POST)
  public List<QMS_R1_ADD> qmsR1Add(@RequestBody Page p) {
    return workPlanService.qmsR1Add(p);
  }

  @RequestMapping(value = "/qmsR1CheckGet", method = RequestMethod.POST)
  public List<QMS_R1_CHECK_GET> qmsR1CheckGet(@RequestBody Page p) {
    return workPlanService.qmsR1CheckGet(p);
  }

  @RequestMapping(value = "/qmsR1CheckOneGet", method = RequestMethod.POST)
  public List<QMS_R1_CHECK_ONE_GET> qmsR1CheckOneGet(@RequestBody Page p) {
    return workPlanService.qmsR1CheckOneGet(p);
  }

  @RequestMapping(value = "/qmsR1CheckAdd", method = RequestMethod.POST)
  public List<QMS_R1_CHECK_ADD> qmsR1CheckAdd(@RequestBody Page p) {
    return workPlanService.qmsR1CheckAdd(p);
  }

  @RequestMapping(value = "/qmsR2CheckGet", method = RequestMethod.POST)
  public List<QMS_R2_CHECK_GET> qmsR2CheckGet(@RequestBody Page p) {
    return workPlanService.qmsR2CheckGet(p);
  }

  @RequestMapping(value = "/qmsR2CheckOneGet", method = RequestMethod.POST)
  public List<QMS_R2_CHECK_ONE_GET> qmsR2CheckOneGet(@RequestBody Page p) {
    return workPlanService.qmsR2CheckOneGet(p);
  }

  @RequestMapping(value = "/qmsR2CheckAdd", method = RequestMethod.POST)
  public List<QMS_R2_CHECK_ADD> qmsR2CheckAdd(@RequestBody Page p) {
    return workPlanService.qmsR2CheckAdd(p);
  }

  @RequestMapping(value = "/qmsR3CheckGet", method = RequestMethod.POST)
  public List<QMS_R3_CHECK_GET> qmsR3CheckGet(@RequestBody Page p) {
    return workPlanService.qmsR3CheckGet(p);
  }

  @RequestMapping(value = "/qmsR3CheckAdd", method = RequestMethod.POST)
  public List<QMS_R3_CHECK_ADD> qmsR3CheckAdd(@RequestBody Page p) {
    return workPlanService.qmsR3CheckAdd(p);
  }

  @RequestMapping(value = "/qmsR3CheckOneGet", method = RequestMethod.POST)
  public List<QMS_R3_CHECK_ONE_GET> qmsR3CheckOneGet(@RequestBody Page p) {
    return workPlanService.qmsR3CheckOneGet(p);
  }

  @RequestMapping(value = "/qmsR4CheckGet", method = RequestMethod.POST)
  public List<QMS_R4_CHECK_GET> qmsR4CheckGet(@RequestBody Page p) {
    return workPlanService.qmsR4CheckGet(p);
  }

  @RequestMapping(value = "/qmsR4CheckAdd", method = RequestMethod.POST)
  public List<QMS_R4_CHECK_ADD> qmsR4CheckAdd(@RequestBody Page p) {
    return workPlanService.qmsR4CheckAdd(p);
  }
}
