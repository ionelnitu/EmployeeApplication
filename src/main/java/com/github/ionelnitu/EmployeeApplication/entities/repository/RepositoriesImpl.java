package com.github.ionelnitu.EmployeeApplication.entities.repository;

import com.github.ionelnitu.EmployeeApplication.entities.Administrator;
import com.github.ionelnitu.EmployeeApplication.entities.Employee;
import com.github.ionelnitu.EmployeeApplication.exception.UserNotFound;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class RepositoriesImpl {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AccountRepository accountRepository;

    public void insertAdministrator(Administrator administrator) {
        accountRepository.save(administrator);
    }

    public void updateAdministrator(Administrator administrator) {
        accountRepository.save(administrator);
    }

    public void insertEmployee(Employee employee) {
        employee.setRegisterTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")));
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Administrator getAdministrator(String email, String password) {
        return accountRepository.findByEmailAndPassword(email, password);
    }
}
