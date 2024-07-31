package com.venkat.service;

import com.venkat.model.Inventory;
import com.venkat.model.ProductOption;

import java.util.concurrent.CompletableFuture;

import static com.venkat.utils.Utils.delay;

public class InventoryService {
    public Inventory addInventory(ProductOption productOption) {
        delay(500);
        return Inventory.builder()
                .count(2).build();

    }

    public CompletableFuture<Inventory> addInventoryWithCF(ProductOption productOption) {
        return CompletableFuture.supplyAsync(() -> {
            delay(500);
            return Inventory.builder()
                    .count(2).build();
        });
    }
}
