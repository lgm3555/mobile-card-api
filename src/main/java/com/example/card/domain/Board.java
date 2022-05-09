package com.example.card.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private String regdate;
}
