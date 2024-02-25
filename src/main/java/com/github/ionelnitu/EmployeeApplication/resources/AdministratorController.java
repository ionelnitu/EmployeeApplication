package com.github.ionelnitu.EmployeeApplication.resources;

import com.github.ionelnitu.EmployeeApplication.entities.Administrator;
import com.github.ionelnitu.EmployeeApplication.entities.repository.RepositoriesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
    Logger logger = Logger.getLogger(AdministratorController.class.getName());

    @Autowired
    RepositoriesImpl repositories;

    @PostMapping("/insert")
    public void insertAdministrator(@RequestBody Administrator administrator){
        repositories.insertAdministrator(administrator);
    }

    @GetMapping("/{email}/{password}")
    public Administrator getAdministrator(@PathVariable("email") String email, @PathVariable("password") String password) {
        logger.log(Level.SEVERE,email + " " + password);
        return repositories.getAdministrator(email, password);
    }

}
