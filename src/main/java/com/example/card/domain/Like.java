package com.example.card.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * tLike 테이블 Model
 */
@Getter
@Setter
@Entity
@Table(name = "tlike")
public class Like {

    @Id
    private String deviceid;

}
