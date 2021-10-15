package com.pirates.pirates_server.product.service;

import com.pirates.pirates_server.product.domain.*;
import com.pirates.pirates_server.product.web.dto.AddProductDTO;
import com.pirates.pirates_server.product.web.dto.OptionsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final OptionsRepo optionsRepo;
    private final DeliveryRepo deliveryRepo;

    @Transactional
    public Long Add(AddProductDTO dto) {
        // product
        Product product_entity = dto.toProductEntity();

        // options
        OptionsDTO[] optionsDTOs = dto.getOptions();

        for(int i=0; i<optionsDTOs.length; i++) {
            product_entity.getOptions().add(optionsDTOs[i].toOptionsEntity());
        }

        // delivery
        Delivery delivery_entity = dto.getDelivery().toDeliveryEntity();
        product_entity.setDelivery(delivery_entity);

        return productRepo.save(product_entity).getId();
    }

    public List<Product> FindAll() {
        return productRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Optional<Product> FindOne(Long id) {
        return productRepo.findById(id);
    }

    public void DeleteById(Long id) {
        productRepo.deleteById(id);
    }
}
