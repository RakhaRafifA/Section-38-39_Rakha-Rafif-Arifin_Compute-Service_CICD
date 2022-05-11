package com.rakharafifa.miniproject.model.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long product_id;
    private String name;
    private String description;
    private Long price;
    private Long quantity;
}
