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

        // options save (save all 로 바꾸기)
        OptionsDTO[] optionsDTOs = dto.getOptions();

        List<Options> options_entity = new ArrayList<Options>();
        for(int i=0; i<optionsDTOs.length; i++) {
            options_entity.add(optionsRepo.save(optionsDTOs[i].toOptionsEntity()));
        }
        System.out.println("=================");
        System.out.println(options_entity.get(0).getName());
        System.out.println("=================");

        // delivery save
        Delivery delivery_entity = deliveryRepo.save(dto.getDelivery().toDeliveryEntity());
        System.out.println("=================");
        System.out.println(delivery_entity.getType());
        System.out.println("=================");

        // product save
        Long product_id = productRepo.save(dto.toProductEntity()).getId();
        return product_id;
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
