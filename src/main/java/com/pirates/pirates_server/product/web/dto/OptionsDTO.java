package com.pirates.pirates_server.product.web.dto;

import com.pirates.pirates_server.product.domain.Delivery;
import com.pirates.pirates_server.product.domain.Options;
import com.pirates.pirates_server.product.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OptionsDTO {
    private String name;
    private int price;
    private int stock;

    @Builder
    public OptionsDTO(
        String name,
        int price,
        int stock
    ) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Options toOptionsEntity() {
        return Options.builder()
                .name(name)
                .price(price)
                .stock(stock)
                .build();
    }

}
