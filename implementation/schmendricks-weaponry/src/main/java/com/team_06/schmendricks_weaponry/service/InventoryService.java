package com.team_06.schmendricks_weaponry.service;

import com.team_06.schmendricks_weaponry.model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.io.InputStream;
import java.util.List;

@Service
public class InventoryService {
    private List<Item> items;

    @PostConstruct
    public void loadItems() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream input = getClass().getResourceAsStream("/data/items.json");
            items = mapper.readValue(input, new TypeReference<List<Item>>(){});
        } catch (Exception e) {
            throw new RuntimeException("Failed to load items.json", e);
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItemsWithId(int id){
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addToCart(int id) {
        Item item = getItemsWithId(id);
        if (item != null) {
            item.setAvailable(false); // mark as unavailable
        }
    }
}