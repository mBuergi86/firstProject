package com.example.firstproject.employees.Controller;

import com.example.firstproject.employees.Model.Employees;
import com.example.firstproject.employees.Service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeesController {
    //@Autowired
    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Employees>> getAllEmployees() {
        return new ResponseEntity<>(employeesService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employees>> getEmployeeById(@PathVariable Integer id) {
        return new ResponseEntity<>(employeesService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/output/{id}")
    public Optional<String> getEmployeeByIdString(@PathVariable Integer id) {
        return employeesService.getEmployeeByIdString(id);
    }

    @PostMapping
    public ResponseEntity<Employees> createEmployee(@RequestBody Employees employees) {
        return employeesService.createEmployee(employees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employees employees) {
        return employeesService.updateEmployee(id, employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id) {
        return employeesService.deleteEmployee(id);
    }
}
