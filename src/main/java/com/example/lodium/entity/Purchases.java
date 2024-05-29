package com.example.lodium.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "purchases")
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int clients_id;
    private int product_id;
    private double cost;


    public Purchases(int id, int clients_id, int product_id, double cost) {
        this.id = id;
        this.clients_id = clients_id;
        this.product_id = product_id;
        this.cost = cost;
    }

    public Purchases(){
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "id=" + id +
                ", clients_id=" + clients_id +
                ", product_id=" + product_id +
                ", cost=" + cost +
                '}';
    }
}
