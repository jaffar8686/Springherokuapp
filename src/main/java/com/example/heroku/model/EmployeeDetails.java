package com.example.heroku.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int age;
    private String employeeName;
    private String designation;
    private String companyName;
    private String address;
    @Column(unique = true)
    private String emailId;
    private String project;
    private String prefix;
    private String gender;
    private String role;
    private String employmentType;
    private String employeeCode;
    private String department;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private Long phoneNumber;
    private Double salary;


}
