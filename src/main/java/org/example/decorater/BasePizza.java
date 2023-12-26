package org.example.decorater;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasePizza implements Pizza{
    private String description;
    private double price;
}
