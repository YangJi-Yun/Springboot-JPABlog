package com.cos.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired // 의존성 주입(DI) 
	// DummyControllerTest 가 메모리에 뜰 때 userRepository를 같이 뜬다.
	// UserRepository타입으로 스프링이 관리하고 있는 객체가 있다면 userRepository 넣어줘라
	// UserRepository 인터페이스가 이미 메모리에 떠있다.
	private UserRepository userRepository;
	//스프링이 @RestController을 읽어서 DummyControllerTest를 메모리에 띄어줄 때는 null이다.
	
	// {id} 주소로 파라미터를 전달받을 수 있음
	// http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		// user=4를 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 된다.
		// null 이  return되면 프로그램에 문제가 있다
		// Optional로 너의 User 객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return 해야한다.
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {

//			@Override
//			public User get() {
//				return new User(); // 빈 객체를 user에 넣는다. = null을 반환하지 않는다.
//			}
//		});
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id : "+id);
			}
		});
		
//		User user = userRepository.findById(id).get();		// findById(id).get() null이 return될 리가 없어.	
		
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				return new User();
//			}
//		});
		
		// 람다식 : orElseThrow() 안에 어떤 타입이 들어가야하는지 신경 안 써도 됨 익명으로 처리할 수 있다.
//			User user = userRepository.findById(id).orElseThrow(()-> {
//				return new IllegalArgumentException("해당 사용자는 없습니다.");
//		});
		
		
		return user;
	}
	
	
	
	//http://localhost:8000/blog/dummy/join (요청)
	//http의 body에  username, password, email 데이터를 가지고 요청 
	@PostMapping("/dummy/join")
	public String join(User user) { 
//		public String join(String username, String password, String email)
//		x-www-form-urlencoded로 전송된 데이터는 key=value (약속된 규칙)로 오는데 
//		스프링의 함수의 파라미터로 파싱해서 집어넣어준다.
		
		System.out.println("id : "+user.getId());
		System.out.println("username : "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("email : "+user.getEmail());
		System.out.println("role : "+user.getRole());
		System.out.println("createDate : "+user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
		
	}
}
