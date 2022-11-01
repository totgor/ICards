package com.icards;

import java.util.ArrayList;

public class Employees {
    public ArrayList<Employee> employeesList;

    Employees() {
        employeesList = new ArrayList<Employee>();
    }

    public void addEmployee(String fio, String department) {
        employeesList.add(new Employee(fio, department));
    }
}
