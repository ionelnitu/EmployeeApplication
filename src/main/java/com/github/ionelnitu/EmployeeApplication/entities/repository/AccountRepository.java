package com.github.ionelnitu.EmployeeApplication.entities.repository;

import com.github.ionelnitu.EmployeeApplication.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Administrator, Long> {
    Administrator findByEmailAndPassword(String email, String Password);
}
