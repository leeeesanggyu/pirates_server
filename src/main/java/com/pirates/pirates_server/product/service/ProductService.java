package com.pirates.pirates_server.product.service;

import com.pirates.pirates_server.product.domain.Product;
import com.pirates.pirates_server.product.domain.ProductRepo;
import com.pirates.pirates_server.product.web.dto.AddProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Transactional
    public Long add(AddProductDTO dto) {
        Long product_id = productRepo.save(dto.toProductEntity()).getId();
        return product_id;
    }
}
