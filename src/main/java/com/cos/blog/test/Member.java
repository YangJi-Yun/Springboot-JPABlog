package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor //lombokTest1
@NoArgsConstructor //빈생성자
public class Member {
	
	// 변수의 상태는 메서드에 의해서 변경이 되게 설계해야 한다.
	private int id;
	private String username;
	private String password;
	private String email;
	
	//lomboktest2
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
	
	
}

//@Getter
//@Setter
//@Data //getter, setter 동시
//@AllArgsConstructor // 생성자
//@RequiredArgsConstructor//불변성 유지를 위해 final 붙은 변수들의 생성자 