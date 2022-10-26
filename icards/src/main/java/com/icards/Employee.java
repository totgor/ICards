package com.icards;

import java.util.ArrayList;

public class Employee {
    private String fio;
    public ArrayList<Equipment> equipmentsList;

    Employee(String fio) {
        this.fio = fio;
        equipmentsList = new ArrayList<Equipment>();
    }

    public void addEquipment(String name, String inventoryNumber) {
        equipmentsList.add(new Equipment(name, inventoryNumber));
    }

    public String getFio() {
        return fio;
    }
}
