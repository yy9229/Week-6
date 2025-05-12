package com.example.employeepayrollapp.repository;

import com.example.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
