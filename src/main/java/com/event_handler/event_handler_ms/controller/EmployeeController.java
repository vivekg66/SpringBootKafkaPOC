package com.event_handler.event_handler_ms.controller;

import com.event_handler.event_handler_ms.model.Example.Employee;
import com.event_handler.event_handler_ms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @PostMapping
    public String addEmpData(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping
    public String deleteEmpData(@RequestBody Employee employee) {
        return employeeService.deleteEmployee(employee);
    }

}
