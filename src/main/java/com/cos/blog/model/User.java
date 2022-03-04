package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // getter, setter
@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 전체생성자
@Builder // 빌더 패턴
//ORM -> Java(다른 언어) Object를 테이블로 매핑해주는 기술
@Entity // User 클래스를 읽어서 자동으로 MySQL에 테이블 생성
public class User {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	// MySQL: auto_increment, Oracle: sequence
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable=false, length=30) // null이 될 수 없고 길이는 30자를 넘을 수 없다.
	private String username; // 아이디
	
	@Column(nullable=false, length=100) // 길이를 길게 잡은 이유: 비밀번호를 해쉬로 변경해서 암호화할 예정(비밀번호 암호화)
	private String password;
	
	@Column(nullable=false, length=50)
	private String email;
	
	@ColumnDefault("'user'") // 문자라는 걸 알려주기 위해 홑따옴표('')로 감싸준다.
	private String role; // Enum을 쓰는게 좋다. ->데이터의 도메인을 만들어 줄 수 있다. admin, user, manager 권한
	// 도메인: 어떤 범위 -> 도메인이 정해졌다= 어떤 범위가 정해졌다.
	// String으로 설정시 오타로 인한 문제를 야기시킬 수 있다. ex)managerrrr라고 입력
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;
	
	// 회원정보 수정용 updateDate
}

//@GeneratedValue 전략
// 기본키를 자동으로 생성하는 방법 4가지 -> 기본키 자동 생성을 위해서는 @Id, @GeneratedValue 어노테이션이 함께 사용되어야 한다.
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//기본키 생성을 데이터베이스에게 위임하는 방식으로 id값을 따로 할당하지 않아도 데이터베이스가 자동으로 auto_increment를 하여 기본키 생성
//@GeneratedValue(strategy = GenerationType.SEQUNCE)
//데이터베이스의  Sequence Object를 사용하여 데이터베이스가 자동으로 기본키를 생성해준다.
//@SequenceGenerator 어노테이션을 필요
//@GeneratedValue(strategy = GenerationType.TABLE)
//키를 생성하는 테이블을 사용하는 방법으로 Sequence와 유사
//@TableGenerator 어노테이션이 필요
//@GeneratedValue(strategy = GenerationTypeAUTO)
//기본 설정 값으로 각 데이터베이스에 따라 기본키를 자동으로 생성
//기본키의 제약 조건
//1. null이면 안된다.
//2. 유일하게 식별할 수 있어야 한다
//3. 변하지 않는 값이어야 한다.

