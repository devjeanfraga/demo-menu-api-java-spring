package com.demo.menuapi.model.dto;

import lombok.Data;

@Data
public class CreateProductDTO {

    private String name;

    private Integer price;

    private String description;
}
