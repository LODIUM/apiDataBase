package com.example.lodium;

import com.example.lodium.controller.ControllerOfClients;
import com.example.lodium.controller.ControllerOfProducts;
import com.example.lodium.controller.ControllerOfPurchases;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LodiumApplication {

	public static void main(String[] args) {
		SpringApplication.run(LodiumApplication.class, args);
	}

}
