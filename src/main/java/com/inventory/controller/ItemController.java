package com.inventory.controller;

import com.inventory.model.item.ItemCreateDTO;
import com.inventory.model.item.ItemResponseDTO;
import com.inventory.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemResponseDTO> addItem(@RequestBody ItemCreateDTO itemDto) {
        return ResponseEntity.ok().body(itemService.addItem(itemDto));
    }

    @GetMapping
    public ResponseEntity<List<ItemResponseDTO>> getAllItem() {
        return ResponseEntity.ok().body(itemService.getAllItems());
    }
}
