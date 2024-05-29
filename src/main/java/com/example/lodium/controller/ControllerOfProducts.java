package com.example.lodium.controller;

import com.example.lodium.entity.Client;
import com.example.lodium.entity.Product;
import com.example.lodium.repository.ProductRep;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ControllerOfProducts {
    private final ObjectMapper objectMapper;
    private final ProductRep productRep;

    @PostMapping("api/productsAdd")
    public void productAdd(@RequestBody Product product){
        productRep.save(product);
    }
    @GetMapping("api/productsAll")
    public String getProductsAll(){
        List<Product> productList = productRep.findAll();
        try{
            return objectMapper.writeValueAsString(productList);
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
    @GetMapping("api/productsById")
    public Product getProductsById(@RequestParam int id){
        return productRep.findById(id).orElseThrow();
    }
    @DeleteMapping("api/productsDelete")
    public void productsDelete(@RequestParam int id){
        productRep.deleteById(id);
    }
    @PutMapping("api/productsChange")
    public String productsChange (@RequestBody Product product){
        if (!productRep.existsById(product.getId())){
            return "No such row";
        }
        return productRep.save(product).toString();
    }
}
