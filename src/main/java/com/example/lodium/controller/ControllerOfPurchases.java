package com.example.lodium.controller;

import com.example.lodium.entity.Client;
import com.example.lodium.entity.Purchases;
import com.example.lodium.repository.ClientRep;
import com.example.lodium.repository.PurchaseRep;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ControllerOfPurchases {
    private final ObjectMapper objectMapper;

    private final PurchaseRep purchaseRep;
    @PostMapping("api/purchasesAdd")
    public void purchasesAdd(@RequestBody Purchases purchases){
        purchaseRep.save(purchases);
    }
    @GetMapping("api/purchasesAll")
    public String getPurchasesAll(){
        List<Purchases> purchasesList = purchaseRep.findAll();
        try {
            return objectMapper.writeValueAsString(purchasesList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("api/purchasesById")
    public Purchases getPurchasesById(@RequestParam int id){
        return purchaseRep.findById(id).orElseThrow();
    }

    @DeleteMapping("api/purchasesDelete")
    public void purchasesDelete (@RequestParam int id){
        purchaseRep.deleteById(id);
    }

    @PutMapping("api/purchasesChange")
    public String purchasesChange(@RequestBody Purchases purchases){
        if (!purchaseRep.existsById(purchases.getId())){
            return "No such row";
        }
        return  purchaseRep.save(purchases).toString();
    }





}
