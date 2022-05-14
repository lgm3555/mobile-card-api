package com.example.card.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * tBoard 테이블 Model
 */
@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "tboard")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    private String id;
    private String pass;
    private String content;
    private LocalDateTime regdate;

    @PreUpdate
    public void initPresist() {
        this.regdate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Board{" +
                "seq=" + seq +
                ", id='" + id + '\'' +
                ", pass='" + pass + '\'' +
                ", content='" + content + '\'' +
                ", regdate='" + regdate + '\'' +
                '}';
    }
}
