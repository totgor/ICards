package com.icards;

import java.util.ArrayList;

public class Employee {
    private String fio;
    private String department;
    public ArrayList<Equipment> equipmentsList;

    Employee(String fio, String department) {
        this.fio = fio;
        this.department department;
        equipmentsList = new ArrayList<Equipment>();
    }

    public void addEquipment(String name, String inventoryNumber) {
        equipmentsList.add(new Equipment(name, inventoryNumber));
    }

    public String getFio() {
        return fio;
    }

    public String getDepartment() {
        return department;
    }
}
