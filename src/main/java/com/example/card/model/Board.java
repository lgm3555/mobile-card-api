package com.example.card.model;

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

    private String name;
    private String pass;
    private String content;
}
