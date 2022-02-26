package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//해당 경로 이하에 있는 파일 리턴
public class TempControllerTest {

	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		// 기본 경로: src/main/resources/statichome.html
//		return "home.html"; // 경로: src/main/resources/statichome.html
		
		// 풀경로: src/main/resources/static/home.html
		return "/home.html"; 
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/a.png";
	}
	
	//application.yml spring부분 주석 해제
	@GetMapping("/temp/first/jsp")
	public String tempJsp1() {
		return "/jspTest1.jsp";
	}
	
	@GetMapping("/temp/second/jsp")
	public String tempJsp2() {
		// prefix : /WEB-INF/views/
		// suffix : .jsp
//		return "/jspTest2.jsp";// 풀네임 : /WEB-INF/views//test.jsp.jsp
		
		return "jspTest2"; //풀네임 : /WEB-INF/views/test.jsp
	}
}
