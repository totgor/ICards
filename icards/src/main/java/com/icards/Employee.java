package com.icards;

public class Employee {
    public String fio;
    public Equipment[] equipments;
    public Employee next;
    public Employee previous;

    Employee() {
        next = null;
        previous = null;
        equipments = new Equipment[100];
        fio = "No name";
    }

    public void addEmployee() {
        
    }

    public void getEmployee() {

    }
}
