package com.example.heroku.controller;


import com.example.heroku.model.EmployeeDetails;
import com.example.heroku.service.EmployeeDetailsService;
import com.example.heroku.service.SendGridEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
public class EmployeeDetailsController {

    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @Autowired
    private SendGridEmail sendGridEmail;

    @GetMapping("/get/all")
    public List<EmployeeDetails> getAllEmployeeDetails(){
        return employeeDetailsService.getAllEmployeeDetails();
    }

    @GetMapping("/get/id/{id}")
    public EmployeeDetails getByEmployeeId(@PathVariable("id") Long id){
        return employeeDetailsService.getByEmployeeId(id);
    }

    @GetMapping("/get/name/{name}")
    public EmployeeDetails getByEmployeeName(@PathVariable("name") String name){
        return employeeDetailsService.getByEmployeeName(name);
    }

    @GetMapping("/get/role/{role}")
    public List<EmployeeDetails> getByEmployeeRole(@PathVariable("role") String role){
        return employeeDetailsService.getByEmployeeRole(role);
    }

    @GetMapping("/get/emailId/{email}")
    public EmployeeDetails getByEmployeeEmailId(@PathVariable("email") String email){
        return employeeDetailsService.getByEmployeeEmailId(email);
    }

    @GetMapping("/get/department/{dept}")
    public List<EmployeeDetails> getByEmployeeDepartment(@PathVariable("dept")String dept){
        return employeeDetailsService.getByEmployeeDepartment(dept);
    }

    @GetMapping("/get/designation/{desig}")
    public List<EmployeeDetails> getByEmployeeDesignation(@PathVariable("desig")String desig){
        return employeeDetailsService.getByEmployeeDesignation(desig);
    }

    @PostMapping("/add")
    public EmployeeDetails addEmployeeDetails(@RequestBody EmployeeDetails employeeDetails){
        return employeeDetailsService.addEmployeeDetails(employeeDetails);
    }

    @PostMapping("/add/all")
    public List<EmployeeDetails> addManyEmployeeDetails(@RequestBody List<EmployeeDetails> employeeDetails){
        return employeeDetailsService.addManyEmployeeDetails(employeeDetails);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id){
        String message = employeeDetailsService.deleteEmployeeById(id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllEmployee(){
        String message = employeeDetailsService.deleteAllEmployee();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<String> updateByEmployeeId(@RequestBody EmployeeDetails details, @PathVariable("id") Long id){
        String message = employeeDetailsService.updateByEmployeeId(details,id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }


}
