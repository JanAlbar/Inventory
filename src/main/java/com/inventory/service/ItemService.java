package com.inventory.service;

import com.inventory.model.Item;
import com.inventory.model.item.ItemCreateDTO;
import com.inventory.model.item.ItemResponseDTO;
import com.inventory.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public ItemService(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    public ItemResponseDTO addItem(ItemCreateDTO itemDto) {
        Item item = modelMapper.map(itemDto, Item.class);
        return modelMapper.map(itemRepository.save(item), ItemResponseDTO.class);
    }

    public List<ItemResponseDTO> getAllItems(){
        return mapToDtoList(itemRepository.findAll());
    }

    private List<ItemResponseDTO> mapToDtoList(List<Item> itemList) {
        return itemList.stream()
                .map(item -> modelMapper.map(item, ItemResponseDTO.class))
                .collect(Collectors.toList());
    }
}
