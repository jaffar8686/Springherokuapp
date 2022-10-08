package com.example.heroku.service;


import com.example.heroku.exception.AlreadyExist;
import com.example.heroku.model.EmployeeDetails;
import com.example.heroku.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeDetailsService {

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;


    public List<EmployeeDetails> getAllEmployeeDetails() {
        return employeeDetailsRepository.findAll();
    }

    public EmployeeDetails getByEmployeeName(String name) {
        return employeeDetailsRepository.getByEmployeeName(name);
    }

    public List<EmployeeDetails> getByEmployeeRole(String role) {
        return employeeDetailsRepository.getByEmployeeRole(role);
    }

    public EmployeeDetails getByEmployeeEmailId(String email) {
        return employeeDetailsRepository.getByEmployeeEmailId(email);
    }

    public List<EmployeeDetails> getByEmployeeDepartment(String dept) {
        return employeeDetailsRepository.getByEmployeeDepartment(dept);
    }


    public List<EmployeeDetails> getByEmployeeDesignation(String desig) {
        return employeeDetailsRepository.getByEmployeeDesignation(desig);
    }

    public EmployeeDetails getByEmployeeId(Long id) {
        return employeeDetailsRepository.findById(id).get();
    }

    public EmployeeDetails addEmployeeDetails(EmployeeDetails employeeDetails) {
        try {

             EmployeeDetails employeeDetails1 = employeeDetailsRepository.findByNameAndEmail(employeeDetails.getEmployeeName(),employeeDetails.getEmailId());

             if(employeeDetails1 == null){
                 return employeeDetailsRepository.save(employeeDetails);
             }
            else {
                throw new AlreadyExist("Employee with name and email address already exist");
             }
        }catch (DataIntegrityViolationException di){
            throw new AlreadyExist("EmailId already exits ");
        }
    }

    public List<EmployeeDetails> addManyEmployeeDetails(List<EmployeeDetails> employeeDetails) {
        return employeeDetailsRepository.saveAll(employeeDetails);
    }

    public String deleteEmployeeById(Long id) {
        try {
            employeeDetailsRepository.deleteById(id);
            return "deleted";
        }catch(Exception e){
            throw new AlreadyExist("No Employee Id Exist");
        }
    }

    public String updateByEmployeeId(EmployeeDetails employeeDetails,Long id) {

        try {

            EmployeeDetails oldDetails = employeeDetailsRepository.findById(id).get();

            if (employeeDetails.getEmployeeCode() != null) {
                oldDetails.setEmployeeCode(employeeDetails.getEmployeeCode());
            } else {
                oldDetails.setEmployeeCode(oldDetails.getEmployeeCode());
            }

            if (employeeDetails.getEmployeeName() != null) {
                oldDetails.setEmployeeName(employeeDetails.getEmployeeName());
            } else {
                oldDetails.setEmployeeName(oldDetails.getEmployeeName());
            }

            if (employeeDetails.getAddress() != null) {
                oldDetails.setAddress(employeeDetails.getAddress());
            } else {
                oldDetails.setAddress(oldDetails.getAddress());
            }

            if (employeeDetails.getAge() != 0) {
                oldDetails.setAge(employeeDetails.getAge());
            } else {
                oldDetails.setAge(oldDetails.getAge());
            }

            if (employeeDetails.getAddress() != null) {
                oldDetails.setAddress(employeeDetails.getAddress());
            } else {
                oldDetails.setAddress(oldDetails.getAddress());
            }

            if (employeeDetails.getCompanyName() != null) {
                oldDetails.setCompanyName(employeeDetails.getCompanyName());
            } else {
                oldDetails.setCompanyName(oldDetails.getCompanyName());
            }

            if (employeeDetails.getDateOfBirth() != null) {
                oldDetails.setDateOfBirth(employeeDetails.getDateOfBirth());
            } else {
                oldDetails.setDateOfBirth(oldDetails.getDateOfBirth());
            }

            if (employeeDetails.getDateOfJoining() != null) {
                oldDetails.setDateOfJoining(employeeDetails.getDateOfJoining());
            } else {
                oldDetails.setDateOfJoining(oldDetails.getDateOfJoining());
            }

            if (employeeDetails.getDepartment() != null) {
                oldDetails.setDepartment(employeeDetails.getDepartment());
            } else {
                oldDetails.setDepartment(oldDetails.getDepartment());
            }

            if (employeeDetails.getDesignation() != null) {
                oldDetails.setDesignation(employeeDetails.getDesignation());
            } else {
                oldDetails.setDesignation(oldDetails.getDesignation());
            }

            if (employeeDetails.getEmailId() != null) {
                oldDetails.setEmailId(employeeDetails.getEmailId());
            } else {
                oldDetails.setEmailId(oldDetails.getEmailId());
            }

            if (employeeDetails.getEmploymentType() != null) {
                oldDetails.setEmploymentType(employeeDetails.getEmploymentType());
            } else {
                oldDetails.setEmploymentType(oldDetails.getEmploymentType());
            }

            if (employeeDetails.getGender() != null) {
                oldDetails.setGender(employeeDetails.getGender());
            } else {
                oldDetails.setGender(oldDetails.getGender());
            }

            if (employeeDetails.getPhoneNumber() != null) {
                oldDetails.setPhoneNumber(employeeDetails.getPhoneNumber());
            } else {
                oldDetails.setPhoneNumber(oldDetails.getPhoneNumber());
            }

            if (employeeDetails.getPrefix() != null) {
                oldDetails.setPrefix(employeeDetails.getPrefix());
            } else {
                oldDetails.setPrefix(oldDetails.getPrefix());
            }

            if (employeeDetails.getProject() != null) {
                oldDetails.setProject(employeeDetails.getProject());
            } else {
                oldDetails.setProject(oldDetails.getProject());
            }

            if (employeeDetails.getSalary() != 0.0) {
                oldDetails.setSalary(employeeDetails.getSalary());
            } else {
                oldDetails.setSalary(oldDetails.getSalary());
            }

            employeeDetailsRepository.save(oldDetails);
            return "updated";
        }catch(NoSuchElementException e){
            throw new AlreadyExist("Employee Id does not exits");
        }
    }

    public String deleteAllEmployee() {
        try {
            employeeDetailsRepository.deleteAll();
            return "deleted";
        }catch(Exception e){
            throw new AlreadyExist("No Employee Data Exists");
        }

    }
}
