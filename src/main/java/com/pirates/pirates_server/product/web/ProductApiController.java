package com.pirates.pirates_server.product.web;

import com.pirates.pirates_server.product.domain.Product;
import com.pirates.pirates_server.product.service.ProductService;
import com.pirates.pirates_server.product.web.dto.AddProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("product")
public class ProductApiController {

    private final ProductService productService;

    /**
     * 상품 등록한다.
     * @param dto
     * @return
     */
    @PostMapping("/")
    public Long AddProduct(
        @RequestBody AddProductDTO dto
    ) {
        return productService.Add(dto);
    }

    /**
     * 상품 등록한다(TEST).
     * @return
     */
    @PostMapping("/test")
    public Long AddProductTest() {
        AddProductDTO dto = AddProductDTO.builder()
            .name("kimchi")
            .description("kimchi description")
            .build();
        return productService.Add(dto);
    }

    @GetMapping("/all")
    public List<Product> GetAllProduct() {
        return productService.FindAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> GetProduct(
            @PathVariable Long id
    ) {
        return productService.FindOne(id);
    }

    @DeleteMapping("/{id}")
    public void DeleteProduct(
            @PathVariable Long id
    ) {
        productService.DeleteById(id);
    }
}