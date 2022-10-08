package com.example.heroku.repository;


import com.example.heroku.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails,Long> {

    @Query(value="select * from employee_details where employee_name = :name",nativeQuery = true)
    public EmployeeDetails getByEmployeeName(String name);

    @Query(value="select * from employee_details where role = :role",nativeQuery = true)
    public List<EmployeeDetails> getByEmployeeRole(String role);

    @Query(value="select * from employee_details where email_id = :email",nativeQuery = true)
    public EmployeeDetails getByEmployeeEmailId(String email);

    @Query(value="select * from employee_details where department = :dept",nativeQuery = true)
    public List<EmployeeDetails> getByEmployeeDepartment(String dept);

    @Query(value="select * from employee_details where designation = :designation",nativeQuery = true)
    public List<EmployeeDetails> getByEmployeeDesignation(String designation);


    @Query(value="select * from employee_details where employee_name = :name and email_id = :email",nativeQuery = true)
    EmployeeDetails findByNameAndEmail(String name, String email);
}

