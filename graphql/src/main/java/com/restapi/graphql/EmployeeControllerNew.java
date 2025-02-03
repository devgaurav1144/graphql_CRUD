package com.restapi.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeControllerNew {

    @Autowired
    private EmployeeRepositoryNew employeeRepositoryNew;


    // Create new employee
    @MutationMapping
    public Employee createEmployeeNew(@Argument String name, @Argument String email, @Argument String department) {
        return employeeRepositoryNew.insertEmployee(name, email, department);
    }

    // Get all employees
    @QueryMapping
    public List<Employee> getEmployeesNew() {
        return employeeRepositoryNew.getAllEmployees();
    }

    
    // Get employee by ID
    @QueryMapping
    public Employee getEmployeeNew(@Argument Integer id) {
        return employeeRepositoryNew.getEmployeeByIdNew(id);
    }

    // Update employee
    @MutationMapping
    public Employee updateEmployeeNew(@Argument Long id, @Argument String name, @Argument String email, @Argument String department) {
        return employeeRepositoryNew.updateEmployee(id, name, email, department);
    }


    // Delete employee
    @MutationMapping
    public Boolean deleteEmployeeNew(@Argument Long id) {
        return employeeRepositoryNew.deleteEmployee(id);
    }
}
