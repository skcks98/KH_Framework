package edu.kh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Java 객체 : new 연산자에 의해 Heap 영역에
//				클래스에 작성된 내용대로 생성된 것

// instance : 개발자가 직접 만들고, 관리하는 객체

@Controller // 요청/응답을 제어할 컨트롤러 역할임을 명시
			// + Bean 등록
public class TestController {
	// 기존 Servlet : 클래스 단위로 하나의 요청만 처리 가능
	// Spring : 메서드 단위로 요청 처리 가능
	
	//@RequestMapping("요청주소")
	// - 요청주소를 처리할 메서드를 매핑하는 어노테이션
	
	// 1) 메서드에 작성 :
	// - 요청 주소와 해당 메서드를 매핑
	// GET/POST 가리지 않고 매핑 (속성을 통해서 지정 가능 or 다른 어노테이션을 이용해서 가능)
	
	/*
	@RequestMapping(value = "/hello", method=RequestMethod.POST)
	public String hello() {
		// 메서드 로직
		
		
		return "경로...";
	}*/
	
	
	
	/*
	// 2) 클래스에 작성
	// - 공통 주소를 매핑
	// ex) todo/insert,todo/select. todo/update..
	
	*/
	/*
	public class 클래스명 {
	@RequestMapping("/insert")
	public String 메서드명 {}
	
	@RequestMapping("/select")
	
	@RequestMapping("/update")
	*/
	
	
		/*
		 * Controller 메서드으 ㅣ반환형이 String인 경우
		 * - 메서드에서 반환되는 문자열이 forwdord
		 * 
		 * 
		 * thymeleaf : JSP 대신 사용하는 템플릿 엔진(html 형태)
		 * 
		 * classpatr : /templates
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		
		
		// src/main/resources/templates/test,xml;
		
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

