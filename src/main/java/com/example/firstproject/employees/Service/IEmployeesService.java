package com.example.firstproject.employees.Service;

import com.example.firstproject.employees.Model.Employees;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IEmployeesService {
    Iterable<Employees> getAllEmployees();
    Optional<Employees> getEmployeeById(Integer id);
    Optional<String> getEmployeeByIdString(Integer id);
    ResponseEntity<Employees> createEmployee(Employees employees);
    ResponseEntity<Employees> updateEmployee(Integer id, Employees employees);
    ResponseEntity<Void> deleteEmployee(Integer id);
}
