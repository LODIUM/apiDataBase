package com.example.lodium.controller;

import com.example.lodium.entity.Client;
import com.example.lodium.repository.ClientRep;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ControllerOfClients {

    private final ObjectMapper objectMapper;

    private final ClientRep clientRep;


    @PostMapping("api/clientsAdd")
    public void clientsAdd(@RequestBody Client client) {
        clientRep.save(client);
    }
    @GetMapping("api/clientsAll")
    public String getClientsAll(){
        List<Client> clientList = clientRep.findAll();
        try {
            return objectMapper.writeValueAsString(clientList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("api/clientsById")
    public Client getClientsById(@RequestParam int id){
        return clientRep.findById(id).orElseThrow();
    }
    @DeleteMapping("api/clientsDelete")
    public void clientsDelete(@RequestParam int id){
        clientRep.deleteById(id);
    }

   @PutMapping("api/clientsChange")
   public String clientsChange(@RequestBody Client client) {
        if (!clientRep.existsById(client.getId())){
            return "No such row";
        }
        return clientRep.save(client).toString();
   }
}