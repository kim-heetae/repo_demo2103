package com.example.demo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/zipcode/*")
public class ZipCodeController {
	Logger logger = LogManager.getLogger(ZipCodeController.class);
	@Autowired(required=true)
	private ZipCodeLogic zipCodeLogic = null;
	
	@RequestMapping("getZipCodeList")
	public String getZipCodeList(HttpServletRequest req) {
		logger.info("getZipCodeList 호출 성공");
		List<Map<String, Object>> zipList = null;
		zipList = zipCodeLogic.getZipCodeList();
		req.setAttribute("zipList", zipList);
		//WEB-INF아래에 있는 zipcode/getZipCodeList.jsp파일을 실행시킨다. - 뒤에 확장자명(.jsp)은 빼야한다.
//		return "zipcode/getZipCodeList";
		//forward나 redirect방식을 사용하면 webapp아래에 있는 zipcode/getZipCodeList.jsp를 실행시킨다.
		return "forward:getZipCodeList.jsp";
	}
	
	@RequestMapping("getZipCodeList2")
	public ModelAndView getZipCodeList2() {
		logger.info("getZipCodeList 호출 성공");
		List<Map<String, Object>> zipList = null;
		zipList = zipCodeLogic.getZipCodeList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("zipcode/getZipCodeList");
		mav.addObject("zipList", zipList);
		//WEB-INF아래에 있는 zipcode/getZipCodeList.jsp파일을 실행시킨다. - 뒤에 확장자명(.jsp)은 빼야한다.
//		return "zipcode/getZipCodeList";
		//forward나 redirect방식을 사용하면 webapp아래에 있는 zipcode/getZipCodeList.jsp를 실행시킨다.
//		return "forward:getZipCodeList.jsp";
		return mav;
	}
}
