package com.team_06.schmendricks_weaponry.model;


import java.util.List;
import java.math.BigDecimal;

public class CartSummary {


    private BigDecimal subtotal;
    private BigDecimal estimatedShipping;
    private BigDecimal estimatedTax;
    private BigDecimal total;
    private ShoppingCart cart;


    public CartSummary(ShoppingCart cart, BigDecimal estimatedShipping) {
        this.cart = cart;

        for(int i = 0; i < cart.getItems().size(); i++) {
            this.subtotal = cart.getItems().get(i).getPrice();
        }

        this.estimatedTax = subtotal.multiply(new BigDecimal(0.08));
        this.estimatedShipping = estimatedShipping;
        this.total = subtotal.add(estimatedShipping).add(estimatedTax);
    }


    public BigDecimal getSubtotal() { return subtotal; }
    public BigDecimal getEstimatedShipping() { return estimatedShipping; }
    public BigDecimal getEstimatedTax() { return estimatedTax; }
    public BigDecimal getTotal() { return total; }
    public ShoppingCart getItems() { return cart; }
}

