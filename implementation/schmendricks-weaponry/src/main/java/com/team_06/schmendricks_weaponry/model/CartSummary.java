package com.team_06.schmendricks_weaponry.model;

import java.math.BigDecimal;
import java.util.List;

public class CartSummary {

    private BigDecimal subtotal;
    private BigDecimal estimatedShipping;
    private BigDecimal estimatedTax;
    private BigDecimal total;
    private ShoppingCart cart;

    public CartSummary(ShoppingCart cart, ShippingOption shipping) {
        this.cart = cart;

        // Calculate subtotal from cart items
        this.subtotal = cart.getTotalPrice();

        // Tax = 6% of subtotal
        this.estimatedTax = subtotal.multiply(new BigDecimal("0.06"));

        // Shipping cost
        this.estimatedShipping = shipping.getCost();

        // Total
        this.total = subtotal.add(estimatedShipping).add(estimatedTax);
    }

    public List<Item> getCartItems() { return cart.getItems(); }
    public BigDecimal getSubtotal() { return subtotal; }
    public BigDecimal getEstimatedShipping() { return estimatedShipping; }
    public BigDecimal getEstimatedTax() { return estimatedTax; }
    public BigDecimal getTotal() { return total; }
    public ShoppingCart getCart() { return cart; }
}
