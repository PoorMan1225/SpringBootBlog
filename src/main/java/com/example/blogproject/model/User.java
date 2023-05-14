package com.example.blogproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 MySql 에 테이블이 생성된다.
public class User {

    @Id // Primary key
    // 프로젝트에서 연결된 db 의 넘버링 전략을 따라간다.
    // 오라클 인 경우 Sequence, MySQL 의 경우 AutoIncrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 시퀀스 , auto_increment

    @Column(unique = true, nullable = false, length = 30)
    private String username; // 아이디
    @Column(nullable = false, length = 100)
    private String password;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)  // 디비에 해당 Enum 이 String 이라고 알려준다.
//    @ColumnDefault("'user'") // 문자라는 것을 알려준다.
    private RoleType role; // Enum 을 쓰는게 좋다. // Enum 이란 전략을 쓰면 해당 도메인(값의 범위) 만큼만 들어갈 수 있다.

    @CreationTimestamp // 시간 자동입력
    private Timestamp createDate;

}
