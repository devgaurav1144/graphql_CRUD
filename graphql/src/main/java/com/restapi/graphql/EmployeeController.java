package com.restapi.graphql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeResolver employeeResolver;

    @MutationMapping
    public Employee createEmployee(@Argument String name, @Argument String email, @Argument String department) {
        return employeeResolver.createEmployee(name, email, department);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument Long id, @Argument String name, @Argument String email, @Argument String department) {
        return employeeResolver.updateEmployee(id, name, email, department);
    }


    @QueryMapping
    public List<Employee> getEmployees() {
        return employeeResolver.getAllEmployees();
    }

    @QueryMapping
    public Optional<Employee> getEmployee(@Argument Long id) {
        return employeeResolver.getEmployee(id);
    }

    @MutationMapping
    public Boolean deleteEmployee(@Argument Long id) {

        return employeeResolver.deleteEmployee(id);

    }

}
