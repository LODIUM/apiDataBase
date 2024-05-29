package com.example.lodium.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String product_name;
    private String country_of_manufacture;
    private Double price;

    public Product(int id, String product_name, String country_of_manufacture, Double price) {
        this.id = id;
        this.product_name = product_name;
        this.country_of_manufacture = country_of_manufacture;
        this.price = price;
    }
    public Product(){
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", country_of_manufactured='" + country_of_manufacture + '\'' +
                ", price=" + price +
                '}';
    }
}
