package com.restapi.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeResolver {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Mutation to create an employee
    public Employee createEmployee(String name, String email, String department) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    // Mutation to update an employee
    public Employee updateEmployee(Long id, String name, String email, String department) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(name);
            employee.setEmail(email);
            employee.setDepartment(department);
            return employeeRepository.save(employee);
        }
        return null;
    }

    // Query to get all employees
    public List<Employee> getAllEmployees() {
        System.out.println("Inside Working");
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    // Mutation to delete an employee
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
