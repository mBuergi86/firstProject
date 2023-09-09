package com.example.firstproject.employees.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.firstproject.employees.Model.Employees;

@Repository
public interface EmployeesRespository extends CrudRepository<Employees, Integer> {

}
