package com.team_06.schmendricks_weaponry.service;

import com.team_06.schmendricks_weaponry.model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for managing inventory items.
 * Loads items from JSON.
 */
@Service
public class InventoryService {

    // List of all items in inventory
    private final List<Item> items = new ArrayList<>();

    public InventoryService() {
        loadItemsFromJson();
    }

    /**
     * Load items from items.json located in resources/data.
     * Converts prices to BigDecimal and stores items in the inventory list.
     */
    private void loadItemsFromJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Item>> typeRef = new TypeReference<>() {};
            InputStream inputStream = getClass().getResourceAsStream("/data/items.json");

            if (inputStream != null) {
                List<Item> jsonItems = mapper.readValue(inputStream, typeRef);
                for (Item i : jsonItems) {
                    i.setPrice(new BigDecimal(i.getPrice().toString())); // ensure BigDecimal type
                    items.add(i);
                }
            } else {
                System.err.println("items.json not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all items in the inventory.
     * @return list of items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Get an item by its ID.
     * @param id the item ID
     * @return the Item if found, otherwise null
     */
    public Item getItemById(int id) {
        return items.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }


    public void setItemAvailable(int id, boolean available) {
        Item item = getItemById(id);
        if (item != null) {
            item.setAvailable(available);
        }
    }
}
