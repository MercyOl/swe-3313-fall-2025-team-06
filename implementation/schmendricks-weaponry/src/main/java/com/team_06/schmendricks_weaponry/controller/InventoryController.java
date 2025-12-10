package com.team_06.schmendricks_weaponry.controller;

import com.team_06.schmendricks_weaponry.model.Item;
import com.team_06.schmendricks_weaponry.service.CartService;
import com.team_06.schmendricks_weaponry.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling inventory page and actions.
 * For viewing available items, searching, and adding items to the cart.
 */
@Controller
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService; // Service to manage inventory items
    private final CartService cartService;           // Service to manage shopping cart

    // Constructor injection for services
    public InventoryController(InventoryService inventoryService, CartService cartService) {
        this.inventoryService = inventoryService;
        this.cartService = cartService;
    }

    /**
     * Displays the inventory page.
     * filters items by a search term.
     */
    @GetMapping
    public String inventoryPage(Model model, @RequestParam(required = false) String search) {
        // Get available items
        List<Item> items = inventoryService.getItems().stream()
                .filter(Item::isAvailable)
                .toList();

        // Apply search filter if provided
        if (search != null && !search.isEmpty()) {
            String lower = search.toLowerCase();
            items = items.stream()
                    .filter(i -> i.getName().toLowerCase().contains(lower))
                    .toList();
        }

        // Add attributes to the model for Thymeleaf
        model.addAttribute("items", items);
        model.addAttribute("cartCount", cartService.getTotalQuantity());
        model.addAttribute("cartTotal", cartService.getTotalPrice());
        return "inventory";
    }

    /**
     * Adds an item to the cart.
     * Returns "success" if added, "error" if the item doesn't exist or is unavailable.
     */
    @PostMapping("/add-to-cart/{id}")
    @ResponseBody
    public String addToCart(@PathVariable int id) {
        Item item = inventoryService.getItemById(id);
        if (item == null || !item.isAvailable()) return "error";

        cartService.addItem(item);
        item.setAvailable(false); // Hide from inventory after adding to cart
        return "success";
    }
}
