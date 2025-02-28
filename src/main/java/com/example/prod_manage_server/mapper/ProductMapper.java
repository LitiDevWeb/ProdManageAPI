package com.example.prod_manage_server.mapper;
import com.example.prod_manage_server.dto.ProductDTO;
import com.example.prod_manage_server.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toProduct(ProductDTO productDTO);

}
