package com.pirates.pirates_server.product.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "options_id")
    private Options options;

    @Builder
    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}