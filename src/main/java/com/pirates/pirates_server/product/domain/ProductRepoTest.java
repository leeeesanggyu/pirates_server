package com.pirates.pirates_server.product.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepoTest {

    @Autowired
    ProductRepo productRepo;

    @After
    public void cleanup() {
        productRepo.deleteAll();
    }

    @Test
    public void Add_Product() {
        String name = "연어";
        String description = "맛있는 연어입니다.";

        productRepo.save(Product.builder()
                .name(name)
                .description(description)
                .build());

    }
}