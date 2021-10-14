package com.pirates.pirates_server.product.web.dto;

import com.pirates.pirates_server.product.domain.Delivery;
import com.pirates.pirates_server.product.domain.Options;
import com.pirates.pirates_server.product.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeliveryDTO {
    private String type;
    private String closing;
    private int price;

    @Builder
    public DeliveryDTO(
            String type,
            String closing,
            int price
    ) {
        this.type = type;
        this.closing = closing;
        this.price = price;
    }

    public Delivery toDeliveryEntity() {
        return Delivery.builder()
                .type(type)
                .closing(closing)
                .price(price)
                .build();
    }

}
