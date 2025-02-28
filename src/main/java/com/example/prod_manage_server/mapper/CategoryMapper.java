package com.example.prod_manage_server.mapper;
import com.example.prod_manage_server.dto.CategoryDTO;
import com.example.prod_manage_server.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    Category toEntity(CategoryDTO categoryDTO);
}
