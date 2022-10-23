package com.icards;

public class Equipment {
    private String name;
    private String inventoryNumber;

    Equipment(String name, String inventoryNamber) {
        this.name = name;
        this.inventoryNumber = inventoryNamber;
    }

    public String getName() {
        return name;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }
}
