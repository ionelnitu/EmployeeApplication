package com.github.ionelnitu.EmployeeApplication.resources;

import com.github.ionelnitu.EmployeeApplication.entities.repository.RepositoriesImpl;
import com.github.ionelnitu.EmployeeApplication.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    RepositoriesImpl repositories;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return repositories.getAllEmployee();
    }

    @PostMapping("/insert")
    public void insertEmployee(@RequestBody Employee employee) {
        repositories.insertEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        repositories.deleteEmployee(id);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee){
        repositories.updateEmployee(employee);
    }

}
