package com.pirates.pirates_server.product.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String type;

    @Column(nullable = false)
    private String closing;

    @Column(nullable = false)
    private int price;

    @Builder
    public Delivery(String type, String closing, int price) {
        this.type = type;
        this.closing = closing;
        this.price = price;
    }
}