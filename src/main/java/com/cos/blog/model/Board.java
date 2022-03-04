package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
	
//	@OneToMany // One=Board, Many=one -> 여러 명의 유저에 의해서 한  개의 게시글을 쓸 수 있다.
//	@OneToOne // One=Board,One=User -> 한 명의 유저에 의해서 한 개의 게시글을 쓸 수 있다.
	@ManyToOne(fetch=FetchType.EAGER) // Many=Board, One=User -> 한 명의 유저에 의해서 여러개의 게시글을 쓸 수 있다.
    //fetch=FetchType.EAGER -> Board를 select시 user를 가져올게
	@JoinColumn(name="userId") // 필드값은 userId로
	private User user; // DB는 오브젝트를 저장할 수 없다. (FK로 연결) but 자바는 오브젝트를 저장할 수 있다.
	
	//fetch=FetchType.LAZY 기본 전략
	@OneToMany(mappedBy="board", fetch=FetchType.EAGER) // mappedBy 연관관계의 주인이 아니다. (난 FK가 아니에요) DB에 컬럼을 만들지 마세요.
//	@JoinColumn(name="replyId") // DB에서 만들어질 필요가 없기 때문에  쓰지 않는다.
	private List<Reply> reply; 
	// reply는 연관관계의 주인이 아니에요. 나는 그냥 Board를 select할 때 조인문을 통해서 값을 얻기 위해 필요한 겁니다.
	@CreationTimestamp
	private Timestamp createDate;
}
