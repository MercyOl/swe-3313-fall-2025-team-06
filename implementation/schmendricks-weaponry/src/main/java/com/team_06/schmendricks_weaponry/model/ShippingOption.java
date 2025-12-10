package com.team_06.schmendricks_weaponry.model;

import java.math.BigDecimal;

public enum ShippingOption {
    OVERNIGHT(new BigDecimal("29")),
    THREE_DAY(new BigDecimal("19")),
    GROUND(new BigDecimal("0"));

    private final BigDecimal cost;

    ShippingOption(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
