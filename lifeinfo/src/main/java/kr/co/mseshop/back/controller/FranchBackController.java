package kr.co.mseshop.back.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mseshop.common.Constants;
import kr.co.mseshop.criteria.EventCriteria;
import kr.co.mseshop.criteria.RentalSearchCriteria;
import kr.co.mseshop.model.FranchEvtVO;
import kr.co.mseshop.model.FranchSellerVO;
import kr.co.mseshop.model.RentalVO;
import kr.co.mseshop.model.RentalVO2;
import kr.co.mseshop.model.StatisVO;
import kr.co.mseshop.service.FranchService;
import kr.co.mseshop.taglib.PageHolder;
import kr.co.mseshop.util.ActionLogUtil;
import kr.co.mseshop.util.FranchEvtUtil;

@Controller
public class FranchBackController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private FranchService franchService;

	@Resource
	private ActionLogUtil actionLogUtil;

	@RequestMapping(value = "/back/franch/list", method = RequestMethod.GET)
	public String getFranchList(Model model, HttpServletRequest request, HttpServletResponse response) {

		List<FranchSellerVO> franchList = franchService.getFranchList();
		actionLogUtil.actionLogUtil(request, "list");
		model.addAttribute("totalCnt", franchList.size());
		model.addAttribute("franchList", franchList);
		return "franchList";
	}

	@RequestMapping(value = "/back/franch/statisList", method = RequestMethod.GET)
	public String getFranchStatistics(Model model, HttpServletRequest request, HttpServletRequest response) {

		String timepigFlag = request.getParameter("event");
		System.out.println("[timepigFlag]" + timepigFlag);
		
		List<StatisVO> statisList = franchService.getStatistics(timepigFlag);

		if (String.valueOf(timepigFlag)!="null") {
			model.addAttribute("flag","timepig");
		} else {
			model.addAttribute("flag","general");
		}
		
		model.addAttribute("statisList", statisList);
		
		return "statisList";
	}

	@RequestMapping(value = "/back/franch/event")
	public String getFranchEvent(Model model, String status, EventCriteria criteria, HttpServletRequest request,
			HttpServletRequest response) throws Exception {

		FranchEvtUtil franchEvtUtil = null;
		try {
			List<FranchEvtVO> franchEvtList = null;
			List<FranchEvtVO> franchSuggestList = null;
			ArrayList<String> suggestEvt = null;
			PageHolder pageHolder = null;

			int allUsersCnt = franchService.getAllUsersCnt();
			int allUseCnt = franchService.getAllUseCnt();

			Map<String, String[]> paramMap = request.getParameterMap();

			if (status.equals("list")) {
				franchEvtList = franchService.getFranchEvent();
			} else if (status.equals("searchDP")) { // datepicker
				System.out.println("[searchDP]....");
				String[] startDate = paramMap.get("startDate_1");
				String[] endDate = paramMap.get("endDate_1");
				System.out.println("[startDate1]" + startDate[0]);
				System.out.println("[endDate1]" + endDate[0]);

				int rowCount = franchService.getEvtRowCount(criteria);

				pageHolder = new PageHolder(rowCount, criteria.getPage(), criteria.getListSize());
				model.addAttribute("pageHolder", pageHolder);

				model.addAttribute("totalCount", rowCount);
				model.addAttribute("currentPage", criteria.getPage());
				model.addAttribute("displayNum", criteria.getListSize());

				franchEvtList = franchService.getFranchDatePickerEvent(startDate[0], endDate[0],
						criteria.getRowBounds());
				allUsersCnt = franchService.__getAllUsersCnt(startDate[0], endDate[0]);
				allUseCnt = franchService.__getAllUseCnt(startDate[0], endDate[0]);
				// All Use count
				// All Users
				// select datepicker list ...
			} else {

				String[] startDate = paramMap.get("startDate");
				String[] endDate = paramMap.get("endDate");
				String[] userCnt = paramMap.get("userCnt");

				System.out.println("[startDate]" + startDate[0]);
				System.out.println("[endDate]" + endDate[0]);

				int rowCount = franchService.getEvtRowCount(criteria);

				pageHolder = new PageHolder(rowCount, criteria.getPage(), criteria.getListSize());
				model.addAttribute("pageHolder", pageHolder);

				model.addAttribute("totalCount", rowCount);
				model.addAttribute("currentPage", criteria.getPage());
				model.addAttribute("displayNum", criteria.getListSize());

				franchEvtList = franchService.getFranchEvent(startDate[0], endDate[0]);
				String value = String.valueOf(paramMap.get("flag")[0]);
				System.out.println("[value]:" + value);
				if (!value.equals("N")) {
					franchEvtUtil = new FranchEvtUtil();
					suggestEvt = (ArrayList<String>) franchEvtUtil.rtnCvtIntValue(franchEvtList, franchEvtList.size(),
							Integer.parseInt(userCnt[0]));

					for (String list : suggestEvt) {
						System.out.println("[list]" + list);
					}

					franchSuggestList = franchService.getFranchSuggestList(suggestEvt);
				}

				allUsersCnt = franchService.__getAllUsersCnt(startDate[0], endDate[0]);
				allUseCnt = franchService.__getAllUseCnt(startDate[0], endDate[0]);
				model.addAttribute("status", "evt");
			}

			model.addAttribute("franchEvtList", franchEvtList);
			model.addAttribute("franchSuggestList", franchSuggestList);
			model.addAttribute("allUsersCnt", allUsersCnt);
			model.addAttribute("allUseCnt", allUseCnt);

		} catch (Exception e) {

			franchEvtUtil.startEvt = false;
			throw new Exception("[Franch Event] event error ...",e);

		}

		return "franchEvent";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/back/franch/franchWrite")
	public String getFranchWrite(Model model, FranchSellerVO franchSellerVO, HttpServletRequest request,
			HttpServletResponse response, @RequestParam(value = "flag", required = false) String flag) {

		JSONObject jObj = new JSONObject();
		if (flag != null && flag.equals("register")) {
			try {
				franchService.addFranchSellerInfo(franchSellerVO);
				jObj.put("result", "success");
				actionLogUtil.actionLogUtil(request, "save");
			} catch (Exception e) {
				e.printStackTrace();
				jObj.put("result", "fail");
			}

			__responseResult(response, jObj);

		} else if (flag != null && flag.equals("view")) {

			FranchSellerVO sellerInfo = franchService.getViewSellerInfo(franchSellerVO.getNo());
			model.addAttribute("sellerInfo", sellerInfo);
			actionLogUtil.actionLogUtil(request, "view");

		} else if (flag != null && flag.equals("update")) {
			try {
				System.out.println("[Event log] " + franchSellerVO.getEvent());
				franchService.updateSellerInfo(franchSellerVO);
				jObj.put("result", "success");
				actionLogUtil.actionLogUtil(request, "update");

			} catch (Exception e) {
				e.printStackTrace();
				jObj.put("result", "fail");
			}
			__responseResult(response, jObj);
		} else if (flag != null && flag.equals("delete")) {
			try {

				franchService.deleteSellerInfo(franchSellerVO.getNo());
				jObj.put("result", "success");
				actionLogUtil.actionLogUtil(request, "delete");

			} catch (Exception e) {
				jObj.put("result", "fail");
			}
			__responseResult(response, jObj);
		}

		return "franchWrite";
	}

	private void __responseResult(HttpServletResponse response, JSONObject jObj) {
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.println(jObj);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/back/franch/rentalSVC")
	public String getRentalSVC(Model model, RentalSearchCriteria rentalSearchCriteria, HttpServletRequest req) {

		if (req.getParameter("status").equals("search")) {
			List<RentalVO> rentalList = franchService.getRentalSvcList(rentalSearchCriteria,
					rentalSearchCriteria.getRowBounds());

			System.out.println("[rentalStatus]" +  rentalSearchCriteria.getRentalStatus());
			
			int rowCount = franchService.getRentalRowCount(rentalSearchCriteria);
			PageHolder pageHolder = null;
			pageHolder = new PageHolder(rowCount, rentalSearchCriteria.getPage(), rentalSearchCriteria.getListSize());
			model.addAttribute("pageHolder", pageHolder);

			model.addAttribute("totalCount", rowCount);
			model.addAttribute("currentPage", rentalSearchCriteria.getPage());
			model.addAttribute("displayNum", rentalSearchCriteria.getListSize());
			model.addAttribute("rentalList", rentalList);
			model.addAttribute("status", "rentalSVC");
			
			if (rentalSearchCriteria.getRentalStatus().equals("3499")) { // 넥센타이어 렌탈
				System.out.println("[status]3499");
				model.addAttribute("rentalStatus","3499");
				
			} else if (rentalSearchCriteria.getRentalStatus().equals("4387")) { // SK 장기 렌터카
				model.addAttribute("rentalStatus","4387");
			}
			
		}

		return "rentalSVC";
	}
	
	@RequestMapping(value = "/back/franch/rentalSVC2")
	public String getRentalSVC2(Model model, RentalSearchCriteria rentalSearchCriteria, HttpServletRequest req) {

		if (req.getParameter("status").equals("search")) {
			List<RentalVO2> rentalList = franchService.getRentalSvcList2(rentalSearchCriteria,
					rentalSearchCriteria.getRowBounds());

			int rowCount = franchService.getRentalRowCount2(rentalSearchCriteria);
			PageHolder pageHolder = null;
			pageHolder = new PageHolder(rowCount, rentalSearchCriteria.getPage(), rentalSearchCriteria.getListSize());
			model.addAttribute("pageHolder", pageHolder);

			model.addAttribute("totalCount", rowCount);
			model.addAttribute("currentPage", rentalSearchCriteria.getPage());
			model.addAttribute("displayNum", rentalSearchCriteria.getListSize());
			model.addAttribute("rentalList", rentalList);
			model.addAttribute("status", "rentalSVC2");
		}

		return "rentalSVC2";
	}

}
