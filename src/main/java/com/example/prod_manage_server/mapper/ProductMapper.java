package com.example.prod_manage_server.mapper;

import com.example.prod_manage_server.dto.ProductDTO;
import com.example.prod_manage_server.dto.ProductOutDTO;
import com.example.prod_manage_server.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category", ignore = true)
    ProductDTO toDTO(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Product toProduct(ProductDTO productDTO);

    ProductOutDTO toProductOutDto(Product product);
}
