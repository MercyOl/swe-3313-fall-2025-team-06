package com.team_06.schmendricks_weaponry.controller;

import com.team_06.schmendricks_weaponry.model.Item;
import com.team_06.schmendricks_weaponry.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 This controller handles everything related to the inventory page.
 It provides endpoints to get items as JSON, display the inventory page,
 and mark items as added to the cart.
*/
@Controller
@RequestMapping("/inventory") // all inventory-related paths start with /inventory so it's easier to find
@CrossOrigin(origins = "*")   // allow requests from any origin
public class InventoryController {

    private final InventoryService service;


    // The service handles all the logic for getting items, adding to cart, etc.
    public InventoryController(InventoryService service) {
        this.service = service;
    }



    /*
     Returns all items as JSON.
    */
    @GetMapping("/api/items")
    @ResponseBody
    public List<Item> getItems() {
        return service.getItems();
    }

    /*
     Returns a single item by its ID as JSON.
    */
    @GetMapping("/api/items/{id}")
    @ResponseBody
    public Item getItemById(@PathVariable int id) {
        return service.getItemsWithId(id);
    }

    // ================= ADD TO CART =================

    /*
     Marks an item as added to the cart by setting its availability to false.
     This prevents it from showing in the inventory page.
    */
    @PostMapping("/add-to-cart/{id}")
    @ResponseBody
    public String addToCart(@PathVariable int id) {
        service.addToCart(id);
        return "success";
    }


    /*
     Loads the inventory page with available items.
     Optional search parameter filters items by name.
     Also counts the items in the cart (unavailable items) for display.
    */
    @GetMapping
    public String inventoryPage(Model model, @RequestParam(required = false) String search) {

        // get only items that are still available
        List<Item> items = service.getItems().stream()
                .filter(Item::isAvailable)
                .toList();

        // filter by search term if provided
        if (search != null && !search.isEmpty()) {
            items = items.stream()
                    .filter(item -> item.getName().toLowerCase().contains(search.toLowerCase()))
                    .toList();
        }

        // count how many items are in the cart (unavailable)
        long cartCount = service.getItems().stream()
                .filter(item -> !item.isAvailable())
                .count();

        // pass the items and cart count to the page for display
        model.addAttribute("items", items);
        model.addAttribute("cartCount", cartCount);

        return "inventory"; // render inventory.html
    }
}
