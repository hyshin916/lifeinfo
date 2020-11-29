package kr.co.mseshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kr.co.mseshop.criteria.RentalCriteria;
import kr.co.mseshop.exceptions.RentalSvcException;
import kr.co.mseshop.model.FranchAdminVO;
import kr.co.mseshop.model.FranchSellerVO;
import kr.co.mseshop.model.RentalVO;
import kr.co.mseshop.model.RentalVO2;
import kr.co.mseshop.service.FranchService;
import kr.co.mseshop.util.Base64Util;
import kr.co.mseshop.util.MakeMD5;

@Controller
public class FranchController {

	@Inject
	private FranchService franchService;

	HashMap<String, String> franchMap = new HashMap<String, String>();

	@RequestMapping(value = "/franch")
	public String franch(@RequestParam(value = "franch", required = false) String franch) {
		if (franch != null) {
			franchMap.put("franch", franch);
		}

		System.out.println("[franch]:" + franchMap.get("franch"));

		return "franch";
	}

	@Inject
	private MakeMD5 makeMD5;

	@RequestMapping(value = "/franch.json", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String franchJSON(@RequestParam(value = "userID", required = false) String userID,
			@RequestParam(value = "userPassword", required = false) String userPassword) {

		Gson gson = new Gson();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		System.out.println("[id]:" + userID);
		/*
		 * System.out.println("[pw]:" + userPassword); System.out.println("[md5]:" +
		 * makeMD5.testMD5(userPassword));
		 */
		/*
		 * int resultVal = franchService.compareIDChk(userID,
		 * makeMD5.testMD5(userPassword));
		 */
		int resultVal = franchService.compareIDChkByID(userID);
		if (resultVal == 1) {
			FranchAdminVO franchAdminVO = franchService.getLimitCnt(franchMap.get("franch"));
			franchMap.put("userID", userID);
			franchMap.put("sellerCd", franchMap.get("franch"));
			int useCnt = franchService.getUseCnt(franchMap);
			System.out.println("useCnt:" + useCnt);

			resultMap.put("franchName", "<" + franchAdminVO.getName() + ">에 방문해 주셔서 감사합니다.");
			if (franchAdminVO.getUseCnt() > useCnt) {
				franchService.addFranchInfo(userID, franchMap.get("franch"));
				useCnt++;
				resultMap.put("comment", "[" + userID + "] 고객님! (" + useCnt + ") 회 방문해 주셨습니다!");

			} else {
				resultMap.put("comment",
						"[" + userID + "] 고객님! 하루 방문회수 (" + franchAdminVO.getUseCnt() + ") 회를 초과하였습니다.관리자에게 문의주세요.");
			}
			System.out.println(resultMap.get("comment"));
		}
		resultMap.put("result", resultVal);
		return gson.toJson(resultMap);
	}

	/*
	 * @RequestMapping(value = "/msFranch.json", method = RequestMethod.GET,
	 * produces = "application/json;charset=UTF-8")
	 * 
	 * @ResponseBody public String msFranchJSON(@RequestParam String callback,
	 * 
	 * @RequestParam(value = "userID", required = false) String userID,
	 * 
	 * @RequestParam(value = "passwd", required = false) String passwd,
	 * 
	 * @RequestParam(value = "view_board", required = false) String view_board,
	 * 
	 * @RequestParam(value = "view_num", required = false) String view_num) {
	 * 
	 * HashMap<String, String> paramMap = new HashMap<String, String>();
	 * System.out.println("[id]:" + userID); System.out.println("[pw]:" + passwd);
	 * System.out.println("[view_board]:" + view_board);
	 * System.out.println("[view_num]:" + view_num);
	 * 
	 * FranchAdminVO franchAdminVO = franchService.getPasswd(view_num);
	 * 
	 * System.out.println("[franchAdmin passwd]:" + franchAdminVO.getPasswd());
	 * 
	 * if (passwd != null && passwd.equals(franchAdminVO.getPasswd())) { // 저장
	 * System.out.println("[msFranch passwd same...");
	 * System.out.println("[userID]:" + userID + "[view_num]:" + view_num);
	 * franchService.addFranchInfo(userID, view_num); paramMap.put("isMember", "1");
	 * } else { paramMap.put("isMember", "0"); } paramMap.put("result", "success");
	 * 
	 * String result = null; ObjectMapper mapper = new ObjectMapper();
	 * 
	 * try { result = mapper.writeValueAsString(paramMap); } catch
	 * (JsonGenerationException e) { e.printStackTrace(); } catch
	 * (JsonMappingException e) { e.printStackTrace(); } catch (IOException e) {
	 * e.printStackTrace(); } System.out.println("reslut: " + result); return
	 * callback + "(" + result + ")"; }
	 */

	@RequestMapping(value = "/msFranch.json")
	public void msFranchJSON(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 전송된 데이터를 추출(id와 콜백 메소드명)
		String callBack = request.getParameter("callback");
		String userID = request.getParameter("userID");
		String passwd = request.getParameter("passwd");
		String view_board = request.getParameter("view_board");
		String view_num = request.getParameter("view_num");
		System.out.println("[id]:" + userID);
		System.out.println("[pw]:" + passwd);
		System.out.println("[view_board]:" + view_board);
		System.out.println("[view_num]:" + view_num);

		FranchAdminVO franchAdminVO = franchService.getPasswd(view_num);

		System.out.println("[franchAdmin passwd]:" + franchAdminVO.getPasswd());
		// 반환 될 데이터
		JSONObject obj = new JSONObject();
		if (passwd != null && passwd.equals(franchAdminVO.getPasswd())) {
			// 저장
			System.out.println("[msFranch passwd same...");
			System.out.println("[userID]:" + userID + "[view_num]:" + view_num);
			franchService.addFranchInfo(userID, view_num);
			obj.put("isMember", "1");
		} else {
			obj.put("isMember", "0");
		}

		// 호출 할 javascript 콜백 메소드를 지정 해 준다.
		PrintWriter out = response.getWriter();
		out.write(callBack + "(" + obj.toString() + ")");
		System.out.println(callBack + "(" + obj.toString() + ")");

		out.flush();
		out.close();
	}

	@RequestMapping(value = "/msFranchPHP.json")
	@ResponseBody
	public String msFranchPHPJSON(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		String userID = String.valueOf(request.getParameter("userID"));
		String passwd = String.valueOf(request.getParameter("passwd"));
		String view_board = String.valueOf(request.getParameter("view_board"));
		String view_num = String.valueOf(request.getParameter("view_num"));
		String eventNm = String.valueOf(request.getParameter("eventNm"));
		System.out.println("[id]:" + userID);
		System.out.println("[pw]:" + passwd);
		System.out.println("[view_board]:" + view_board);
		System.out.println("[view_num]:" + view_num);
		System.out.println("[eventNm]:" + eventNm);

		FranchAdminVO franchAdminVO = franchService.getPasswd(view_num);

		if (passwd != "null" && passwd.equals(franchAdminVO.getPasswd())) {
			if (eventNm.equals("timepig") && getUseCnt(userID, view_num) == 3) { 
				resultMap.put("isMember", "3");
			} else {

				if (eventNm.equals("")) {
					franchService.addFranchInfo(userID, view_num);
				} else {
					franchService.addFranchTpInfo(userID, view_num, eventNm);
				}

				resultMap.put("isMember", "1");
			}
		} else {
			resultMap.put("isMember", "0");
		}
		return gson.toJson(resultMap);
	}

	private int getUseCnt(String userID, String view_num) {

		int useCnt = franchService.getUseFranchInfo(userID, view_num);

		return useCnt;
	}

	@RequestMapping(value = "/msFranchUseCnt.json")
	@ResponseBody
	public String msFranchUseCnt(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		String userID = request.getParameter("userID");
		String view_num = request.getParameter("view_num");

		int useCnt = getUseCnt(userID, view_num);
		System.out.println("[UseCnt]" + useCnt);
		resultMap.put("useCnt", useCnt);

		return gson.toJson(resultMap);
	}

	@RequestMapping(value = "/msFranchTotalUseCnt.json", produces = "application/json; charset=utf8")
	@ResponseBody
	public String msFranchTotalUseCnt(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<FranchSellerVO> franchTotalUseCntList = franchService.getFranchTotalUseCntList();

		Gson gson = new Gson();

		String status = request.getParameter("status");

		if (status != null && status.equals("total")) {

			JsonObject jsonObject = new JsonObject();
			JsonArray jsonArray = new JsonArray();

			for (FranchSellerVO franchSellerVO : franchTotalUseCntList) {
				jsonObject.addProperty("name", franchSellerVO.getName());
				jsonObject.addProperty("franchCD", franchSellerVO.getSellerCd());
				jsonObject.addProperty("totalUseCnt", franchSellerVO.getUseCnt());
				jsonArray.add(jsonObject);
				jsonObject = new JsonObject();
			}
			jsonObject.add("useCnt", jsonArray);
			jsonArray = new JsonArray();
			return gson.toJson(jsonObject);

		} else {
			HashMap<String, Object> resultMap = new HashMap<String, Object>();

			String view_num = request.getParameter("view_num");

			int useCnt = franchService.getUseTotalFranchInfo(view_num);

			resultMap.put("useCnt", useCnt);

			return gson.toJson(resultMap);
		}

	}

	@RequestMapping(value = "/msFranchRentalRcv.json", produces = "application/json; charset=utf8")
	@ResponseBody
	public String rentalRcv(RentalCriteria rentalCriteria, RentalVO rentalVO) throws IOException {
		Gson gson = new Gson();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		try {
			String[] tire = rentalCriteria.getTire1().split("_");
			String tireSetValue = tire[0] + "/" + tire[1] + "R " + tire[2];
			if (rentalCriteria.getUserID() == "" || rentalCriteria.getUserID() == null) {
				throw new RentalSvcException("id null");
			}
			rentalVO.setId(rentalCriteria.getUserID());

			/*
			 * System.out.println("[Rental CarKind]" +
			 * Base64Util.getInstance().deCoder(rentalCriteria.getCarKind()));
			 * System.out.println("[Rental Local]" +
			 * Base64Util.getInstance().deCoder(rentalCriteria.getRentalLocal()));
			 */
			// rentalVO.setKind(Base64Util.getInstance().deCoder(rentalCriteria.getCarKind()));
			rentalVO.setKind(rentalCriteria.getCarKind());
			rentalVO.setSize(tireSetValue);
			// rentalVO.setLocal(Base64Util.getInstance().deCoder(rentalCriteria.getRentalLocal()));
			rentalVO.setLocal(rentalCriteria.getRentalLocal());
			rentalVO.setCode(rentalCriteria.getCode());

			franchService.addRentalInfo(rentalVO);
			resultMap.put("result", "1");

		} catch (RentalSvcException e) {
			System.out.println("[System msg]:" + e.getMessage());
			resultMap.put("result", "0");
		} catch (ArrayIndexOutOfBoundsException ex) {
			resultMap.put("result", "0");
			throw new RentalSvcException("Tire Size value Error...");
		} catch (NullPointerException ex1) {
			resultMap.put("result", "0");
			throw new RentalSvcException("Tire parameter name Error...");
		}

		return gson.toJson(resultMap);
	}

	@RequestMapping(value = "/msFranchRentalRcv2.json", produces = "application/json; charset=utf8")
	@ResponseBody
	public String rentalRcv2(RentalVO2 rentalVO2) throws IOException {
		Gson gson = new Gson();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		try {

			franchService.addRentalInfo2(rentalVO2);
			resultMap.put("result", "1");

		} catch (Exception e) {
			resultMap.put("result", "0");
		}

		return gson.toJson(resultMap);
	}

}
