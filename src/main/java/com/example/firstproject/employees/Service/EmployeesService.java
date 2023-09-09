package com.example.firstproject.employees.Service;

import com.example.firstproject.employees.Model.Employees;
import com.example.firstproject.employees.Repository.EmployeesRespository;
import com.example.firstproject.employees.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeesService implements IEmployeesService {
    //@Autowired
    private final EmployeesRespository employeesRespository;
    private final Util utils;

    @Autowired
    public EmployeesService(EmployeesRespository employeesRespository) {
        this.employeesRespository = employeesRespository;
        utils = new Util();
    }

    @Override
    public Iterable<Employees> getAllEmployees() {
        return employeesRespository.findAll();
    }

    @Override
    public Optional<Employees> getEmployeeById(Integer id) {
        return employeesRespository.findById(id);
    }

    @Override
    public Optional<String> getEmployeeByIdString(Integer id) {
        Optional<Employees> employees = employeesRespository.findById(id);
        if (employees.isPresent()) {
            Employees employee = employees.get();
            return Optional.of("Hallo " + employee.getName() + " " + employee.getVorname());
        }
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Employees> createEmployee(Employees employees) {
        employeesRespository.save(employees);
        return ResponseEntity.ok(employees);
    }

    @Override
    public ResponseEntity<Employees> updateEmployee(Integer id, Employees employees) {
        Optional<Employees> optionalEmployee = employeesRespository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employees employee = optionalEmployee.get();

            Map<String, Object> changes = new HashMap<>();

            // Fügen Sie alle Felder hinzu, die Sie aktualisieren möchten
            if (employees.getName() != null) changes.put("name", employees.getName());
            if (employees.getVorname() != null) changes.put("vorname", employees.getVorname());
            if (employees.getHausnummer() != null) changes.put("hausnummer", employees.getHausnummer());
            if (employees.getPlz() != null) changes.put("plz", employees.getPlz());
            if (employees.getOrt() != null) changes.put("ort", employees.getOrt());
            if (employees.getEmail() != null) changes.put("email", employees.getEmail());
            if (employees.getMobilnetz() != null) changes.put("mobilnetz", employees.getMobilnetz());
            if (employees.getGeschlecht() != null) changes.put("geschlecht", employees.getGeschlecht());

            // Aktualisieren Sie die Felder basierend auf den Änderungen in der Map
            utils.UpdateFields(employee, changes);

            employeesRespository.save(employee);
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Integer id) {
        employeesRespository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
