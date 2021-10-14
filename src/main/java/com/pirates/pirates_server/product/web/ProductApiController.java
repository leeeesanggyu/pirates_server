package com.pirates.pirates_server.product.web;

import com.pirates.pirates_server.product.domain.Product;
import com.pirates.pirates_server.product.service.ProductService;
import com.pirates.pirates_server.product.web.dto.AddProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("product")
public class ProductApiController {

    private final ProductService productService;

    @PostMapping("/")
    public Long AddProduct(
        @RequestBody AddProductDTO dto
    ) {
        return productService.add(dto);
    }

    @PostMapping("/test")
    public Long AddProductTest() {
        AddProductDTO dto = AddProductDTO.builder()
            .name("kimchi")
            .description("kimchi description")
            .build();
        return productService.add(dto);
    }

}