package com.example.prod_manage_server.dto;

import lombok.Data;

@Data
public class ProductOutDTO {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}