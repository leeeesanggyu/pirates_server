package com.pirates.pirates_server.product.web.dto;

import com.pirates.pirates_server.product.domain.Delivery;
import com.pirates.pirates_server.product.domain.Options;
import com.pirates.pirates_server.product.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class AddProductDTO {
    private String name;
    private String description;
    private DeliveryDTO delivery;
    private OptionsDTO[] options;

    @Builder
    public AddProductDTO(
        String name,
        String description
    ) {
        this.name = name;
        this.description = description;
    }

    public Product toProductEntity() {
        return Product.builder()
                .name(name)
                .description(description)
                .build();
    }


}
