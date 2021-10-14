package com.pirates.pirates_server.product.web.dto;

import com.pirates.pirates_server.product.domain.Delivery;
import com.pirates.pirates_server.product.domain.Options;
import com.pirates.pirates_server.product.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddProductDTO {
    private String name;
    private String description;
//    private Delivery delivery;
//    private Options options;

    @Builder
    public AddProductDTO(
        String name,
        String description
//        Delivery delivery,
//        Options options
    ) {
        this.name = name;
        this.description = description;
//        this.delivery = delivery;
//        this.options = options;
    }

    public Product toProductEntity() {
        return Product.builder()
                .name(name)
                .description(description)
                .build();
    }

}
