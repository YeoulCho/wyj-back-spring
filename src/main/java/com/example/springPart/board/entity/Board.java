package com.example.springPart.board.entity;

import com.example.springPart.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@ToString
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    private String memberId;
    //private Member author;
    //TODO: MEMBER 엔티티 구현후 Member author로 바인딩

    @Setter
    private String title;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Content content;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
    public Board(String memberId, String title, Content content) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
    }
}
