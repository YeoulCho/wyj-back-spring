package com.example.springPart.board.entity;

import com.example.springPart.member.entity.Member;
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
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    private Long author;
    //private Member author;
    //TODO: MEMBER 엔티티 구현후 Member author로 바인딩

    @Setter
    @Getter
    private String title;
    @OneToOne(fetch = FetchType.LAZY)
    @Getter
    private Content content;
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
    public Board(Long authorID, String title, Content content) {
        this.author = authorID;
        this.title = title;
        this.content = content;
    }
}
