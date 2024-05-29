package com.example.lodium.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String number_phone;



    public Client( String first_name, String last_name, String email, String number_phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.number_phone = number_phone;
    }

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", number_phone='" + number_phone + '\'' +
                '}';
    }
}
