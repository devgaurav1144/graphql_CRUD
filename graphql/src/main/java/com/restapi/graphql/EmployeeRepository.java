package com.restapi.graphql;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface  EmployeeRepository extends JpaRepository<Employee,Long>{


}


