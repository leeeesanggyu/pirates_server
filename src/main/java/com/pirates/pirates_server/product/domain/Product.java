package com.pirates.pirates_server.product.domain;

import com.pirates.pirates_server.product.web.dto.AddProductDTO;
import com.pirates.pirates_server.product.web.dto.DeliveryDTO;
import com.pirates.pirates_server.product.web.dto.OptionsDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
@Data
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

    @CreationTimestamp
    private LocalDateTime create_at;

    @OneToMany(
            targetEntity = Options.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "options_id")
    private List<Options> options = new ArrayList<>();

    @OneToOne(
            targetEntity = Delivery.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Builder
    public Product(
        String name,
        String description
    ) {
        this.name = name;
        this.description = description;
    }



}