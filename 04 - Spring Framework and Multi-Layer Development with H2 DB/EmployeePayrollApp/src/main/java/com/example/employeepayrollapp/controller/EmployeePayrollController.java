package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return repository.findById(id)
                .map(emp -> {
                    emp.setName(employee.getName());
                    emp.setSalary(employee.getSalary());
                    return repository.save(emp);
                })
                .orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        return "Employee deleted successfully!";
    }
}
