package com.example.demo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/di/*")
public class MapController {
	private Map<String, String> mapBean = null;
	//myBatis의 경우 java가 아니고 자바코드는 jar의 형태로 주입되므로 
	//constructor주입법으로 처리한다.
	//DB커넥션 풀도 자바 표준에서 제공하는 것은 아니니까 
	//생성자 객체 주입법으로 처리해야 할 것이다.(XML에서 처리하는 것)
	//setter객체 주입법 - java에 코딩하는 방법
	public void setMapBean(Map<String, String> mapBean) {
		this.mapBean = mapBean;
	}
	@RequestMapping("mapTest")
	public String mapTest() 
	{
		System.out.println(mapBean.get("proc1"));
		return "redirect:mapTest.jsp";
	}
}
