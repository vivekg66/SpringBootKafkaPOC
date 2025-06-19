package com.event_handler.event_handler_ms.service;


import com.event_handler.event_handler_ms.model.Example.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public String addEmployee(Employee employee) {
        employeeList.add(employee);
        return "employee added";
    }

    public String deleteEmployee(Employee employee) {
        employeeList.remove(employee);
        return "employee deleted";
    }


}
