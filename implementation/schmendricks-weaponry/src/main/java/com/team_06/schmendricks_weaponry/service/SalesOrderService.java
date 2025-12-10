package com.team_06.schmendricks_weaponry.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import com.team_06.schmendricks_weaponry.model.SalesOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesOrderService {

    // ObjectMapper for handling JSON serialization/deserialization
    private final ObjectMapper mapper = new ObjectMapper();

    // File path to store sales order data (placed in resources/data)
    private final File salesDataFile = new File("src/main/resources/data/SalesData.json");


    public List<SalesOrder> loadSalesOrders() {
        try {

            return mapper.readValue(salesDataFile, new TypeReference<List<SalesOrder>>() { } );

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveSalesOrders(List<SalesOrder> orderList) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(salesDataFile, orderList);
    }

    public void addSalesOrder(SalesOrder newOrder) throws IOException {
        List<SalesOrder> orderList = loadSalesOrders();

        int newId = orderList.size();
        newOrder.setOrderId(newId);

        orderList.add(newOrder);
        saveSalesOrders(orderList);
    }

    public Optional<SalesOrder> getOrderById(int id) {
        return loadSalesOrders().stream()
                .filter(order -> order.getOrderId() == id)
                .findFirst();
    }
}
