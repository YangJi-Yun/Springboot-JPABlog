package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자 요청 -> 응답(HTML 파일)
//@Controller

//사용자 요청 -> 응답(Data)
@RestController
public class HttpcontrollerTest {
	
	//인터넷 브라우저 요청은 무조건 get방식밖에 할 수 없다.
	//http://localhost:8080/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) { //id=1&username=cos&password=1234&email=ssar@nate.com //get방식으로 데이터를 요청할 때는  QueryString방법밖에 없다.
		return "get 요청 :"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
		
	//	public String getTest(@RequestParam int id, @RequestParam String username) {
	//	return "get 요청 :"+id+", "+username;
	//}
	
	//http://localhost:8080/http/post (insert)
	@PostMapping("/http/post")
		public String postTest(Member m) {//MIME 타입 : x-www-form=urlencoded = <form><input type=""></form> //MessageConverter (스프링부트) 오브젝트에 맵핑 시켜줌
			return "post 요청 :"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
		}
			
	//	public String postTest(@RequestBody String text) { //MIME 타입 : raw-text=text/plain
	//		return "post 요청 :"+text;
	//	}
	//@RequstBody (Body데이터 받기 )=>Object로 Mapping해서 받을 수 있다.
	
	//	public String postTest(@RequestBody Member m) { //MIME 타입 : raw-json=application/json //MessageConverter (스프링부트) 오브젝트에 맵핑 시켜줌
	//		return "post 요청 :"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	//	}
	
	//http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 :"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
	//http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}

//크롬 개발자모드 - Network - F5 - Name 클릭- Headers 확인
//postman  http통신 4가지 방식
//http405 : 해당 메서드가 해당 허용되지 않는다. 