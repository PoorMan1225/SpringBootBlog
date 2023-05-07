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
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 200) // 대용량 데이터
    private String content; // 섬머노트 라이브러리

    @ManyToOne
    @JoinColumn(name="boardId")
    private Board board;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;
}
