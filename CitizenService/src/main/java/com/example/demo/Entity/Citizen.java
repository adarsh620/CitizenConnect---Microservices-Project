package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-generate the primary key
    private int id;

    @Column(nullable = false) // Adding a constraint to ensure 'name' is not null
    private String name;

 
    private int vaccinationCenterId;

}
