package com.example.blogproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content; // 섬머노트 라이브러리

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user; // 데이터 베이스에서는 fk 로 들어가게 된다. 객체를 저장할 수 없기 때문에.

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy 연관관계의 주인이 아니다 (fk 가 아니다)
    private List<Reply> replyList;

    @CreationTimestamp
    private Timestamp createDate;
}


