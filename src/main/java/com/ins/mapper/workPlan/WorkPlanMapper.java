package com.ins.mapper.workPlan;

import java.util.List;

import com.ins.common.dto.Message;
import com.ins.common.dto.Page;
import com.ins.workPlan.dto.*;

import org.springframework.stereotype.Repository;

@Repository
public interface WorkPlanMapper {

  List<List<Object>> workPlanGet(Page p);

  Message workTeamAdd(Page p);

  List<List<Object>> insPlanStatusGet(Page p);

  Message attendanceAdd(Page p);

  List<SCM_ORD> scmOrdGet(Page p);

  List<SCM_ORD_SUB> scmOrdSubGet(Page p);

  List<SCM_QC_ITEM> scmQcItemGet(Page p);

  Message insPlanAdd(INS_PLAN_ADD ipa);

  List<COMMON_LIST> commonGet(Page p);

  List<PLACE_DAY_GET> placeDayGet(Page p);

  Message expenseAdd(Page p);

  List<INS_EXPENSE_GET> expenseGet(Page p);

  List<INS_BEFORE_IMG> beforeImgGet(Page p);

  Message expenseDel(Page p);

  Message scmInAdd(Page p);

  List<SYS_PART_GET> partListGet(Page p);

  List<USER_MENU_GET> menuListGet(Page p);

  Message scmOutAdd(Page p);

  Message scmRetInAdd(Page p);

  List<OUTS_LIST_GET> outsListGet(Page p);

  Message outsAdd(Page p);

  List<CLAIM_LIST_GET> claimListGet(Page p);

  Message claimAdd(Page p);

  List<INS_TEA_GET> teamListGet(Page p);

  Message teamChangeAdd(Page p);

  Message claimTeadAdd(Page p);

  List<INS_PLAN_TPM_GET> empListGet(Page p);

  List<SCM_ORD_SUB> scmSub(String ord_no);

  List<OUTS_LIST_GET2> outsListGet2(OUTS_LIST_GET outs);

  List<OUTS_LIST_GET3> outsListGet3(OUTS_LIST_GET2 outs2);

  List<List<Object>> workPlanCompGet(Page p);

  List<List<Object>> workPlanGet2(Page p);

  List<INS_BEFORE_IMG> claimImgGet(Page p);

  List<WMS_OUT_CRM_GET> wmsOutCrmGet(Page p);

  List<WMS_OUT_IMG> wmsOutImgGet(Page p);

  Message wmsOutAdd(Page p);

  List<INS_IMAGE_GET> insImgGet(Page p);

  List<SCM_ORD> scmOrdGet2(Page p);

  List<SCM_ORD_SUB> scmSub2(String ord_no);

  List<SCM_ORD_SUB> scmOrdSubGet2(Page p);

  List<QMS_R4_GET> qmsR4Get(Page p);

  List<QMS_R4_ADD> qmsR4Add(Page p);

  List<MB_QMS_OUT_ORD_GET> qmsOutOrdGet(Page p);

  List<QMS_OUT_IMG_GET> QmsOutImgGet(Page p);

  List<List<Object>> QmsOutListGet(Page p);

  List<QMS_R3_ADD> qmsR3Add(Page p);

  List<QMS_ROUTE_GET> qmsRoutGet(Page p);

  List<QMS_R2_LIST_GET> qmsR2Get(Page p);

  List<QMS_R2_LIST_ADD> qmsR2Add(Page p);

  List<PLAN_QTY_GET> planQtyGet(Page p);

  List<SCM_QMS_ORD_GET> scmQmsOrdGet(Page p);

  List<SCM_QMS_R1_GET> scmQmsR1Get(Page p);

  List<QMS_R1_IMG_GET> qmsR1ImgGet(Page p);

  Message R1ImgAdd(R1_IMG_ADD ipa);

  List<QMS_R1_ADD> qmsR1Add(Page p);

  List<QMS_R1_CHECK_GET> qmsR1CheckGet(Page p);

  List<QMS_R1_CHECK_ONE_GET> qmsR1CheckOneGet(Page p);

  List<QMS_R1_CHECK_ADD> qmsR1CheckAdd(Page p);

  List<QMS_R2_CHECK_GET> qmsR2CheckGet(Page p);

  List<QMS_R2_CHECK_ONE_GET> qmsR2CheckOneGet(Page p);

  List<QMS_R2_CHECK_ADD> qmsR2CheckAdd(Page p);

  List<QMS_R3_CHECK_GET> qmsR3CheckGet(Page p);

  List<QMS_R3_CHECK_ADD> qmsR3CheckAdd(Page p);

  List<QMS_R3_CHECK_ONE_GET> qmsR3CheckOneGet(Page p);

  List<QMS_R4_CHECK_GET> qmsR4CheckGet(Page p);

  List<QMS_R4_CHECK_ADD> qmsR4CheckAdd(Page p);

}
