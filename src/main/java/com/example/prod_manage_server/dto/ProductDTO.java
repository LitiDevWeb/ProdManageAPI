package com.example.prod_manage_server.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProductDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private Double price;
    @NotBlank
    private Integer quantity;
    @NotNull
    private Long category;

}
