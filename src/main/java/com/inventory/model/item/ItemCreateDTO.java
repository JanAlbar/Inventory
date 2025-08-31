package com.inventory.model.item;

import com.inventory.model.enums.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemCreateDTO {
    private Long id;
    private String name;
    private Category category;
    private int quantity;
    private double price;
    private String supplier;
}
