package com.restapi.graphql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepositoryNew extends JpaRepository<Employee, Long>{

      // Insert new employee using PostgreSQL function
    @Query(value = "SELECT * FROM register_employee_backup(:name, :email, :department) ", nativeQuery = true)
    Employee insertEmployee(@Param("name") String name, @Param("email") String email, @Param("department") String department);


    // Get all employees using PostgreSQL function
    @Query(value = "SELECT * FROM get_all_employees()", nativeQuery = true)
    List<Employee> getAllEmployees();

    // Get employee by ID using PostgreSQL function
    @Query(value = "SELECT * FROM get_employee_by_id(:id)", nativeQuery = true)
    Employee getEmployeeByIdNew(@Param("id") Integer id);


    // Update employee using PostgreSQL function
    @Query(value = "SELECT * FROM update_employee(:id, :name, :email, :department)", nativeQuery = true)
    Employee updateEmployee(@Param("id") Long id, @Param("name") String name, @Param("email") String email, @Param("department") String department);


    // Delete employee using PostgreSQL function
    @Query(value = "SELECT delete_employee(:id)", nativeQuery = true)
    Boolean deleteEmployee(@Param("id") Long id);

}
