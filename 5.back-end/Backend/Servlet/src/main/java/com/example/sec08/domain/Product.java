package com.example.sec08.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Database와 매핑되는 Entity 클래스
@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "prdno")
    private String prdNo;

    @Column(name = "prdname")
    private String prdName;

    @Column(name = "prdprice")
    private int prdPrice;

    @Column(name = "prdmaker")
    private String prdMaker;

    @Column(name = "prdcolor")
    private String prdColor;

    @Column(name = "ctgno")
    private int ctgNo;
}
