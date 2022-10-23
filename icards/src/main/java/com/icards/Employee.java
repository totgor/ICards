package com.icards;

import java.util.ArrayList;

public class Employee {
    private String fio;
    public ArrayList<Equipment> equipments;

    Employee(String fio) {
        this.fio = fio;
        equipments = new ArrayList<Equipment>();
    }

    public void addEquipment(String name, String inventoryNumber) {
        equipments.add(new Equipment(name, inventoryNumber));
    }

    public String getFio() {
        return fio;
    }
}
