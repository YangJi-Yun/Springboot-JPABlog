package com.cos.blog.lombok;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//스프링이 com.cos.blos 패키지 이하를 스캔해서 모든 파일을 메모리에  new 하는 것은 아니다
//특정 어노테이션이 붙어있는 클래스 파일들을 new해서(IoC) 스프링 컨테이너에 관리해준다.
//controller라는 어노테이션을 붙이면 스프링이 메모리에 띄어준다.
@RestController
public class BlogControllerTest {

	//http://localhost:8080/test/hello
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello spring boot</h1>";
	}
}
