package com.example.card.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * tBoard 테이블 Model
 */
@Getter
@Setter
@Entity
@Table(name = "tboard")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    private String id;
    private String pass;
    private String content;
    private String regdate;

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
