package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	
	@Column(nullable=false, length=100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인 됨.
	
	@ColumnDefault("0") // 데이터베이스에서 Number값이기 때문에 홑따옴표는 사용하지 않는다.
	private int count; // 조회수
	
	@ManyToOne // Many=Board, One=User -> 한 명의 유저에 의해서 여러개의 게시글을 쓸 수 있다.
//	@OneToMany // One=Board, Many=one -> 여러 명의 유저에 의해서 한  개의 게시글을 쓸 수 있다.
//	@OneToOne // One=Board,One=User -> 한 명의 유저에 의해서 한 개의 게시글을 쓸 수 있다.
	@JoinColumn(name="userId") // 필드값은 userId로
	private User user; // DB는 오브젝트를 저장할 수 없다. (FK로 연결) but 자바는 오브젝트를 저장할 수 있다.
	
	@CreationTimestamp
	private Timestamp createDate;
}
