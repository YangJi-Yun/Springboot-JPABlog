package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;

// DAO
// 자동으로 bean 등록이 된다. [bean으로 등록한다 = 스프링 IoC에서 객체를 가지고 있다. ()]
// @Repository (컴포넌트 스캔시 메모리에 띄운다.) 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{
	//해당(UserRepository) JpaRepository는 User테이블을 관리하는 repository고 User테이블의 primary key는 Integer다.
	
}
