package com.example.departmentservice.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.departmentservice.entity.Department;
import com.example.departmentservice.service.DepartmentService;


@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        
    	return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.OK);
   
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable("id") Long departmentId) {

    	return new ResponseEntity<Department>(departmentService.findDepartmentById(departmentId), HttpStatus.OK);
        
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Department>> findAllDepartment() {
        
    	return new ResponseEntity<List<Department>>(departmentService.findAllDepartment(), HttpStatus.OK);
   
    }
    
	/*
	 * @PutMapping("/{id}") public ResponseEntity<Department>
	 * updateDepartmentById(@PathVariable("id") Long departmentId) {
	 * 
	 * return new ResponseEntity<Department>(departmentService.updateDepartmentById(
	 * departmentId), HttpStatus.OK);
	 * 
	 * }
	 */
    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") Long departmentId){
    	
    	departmentService.deleteDepartmentById(departmentId);
    	return new ResponseEntity<String>("Department deleted successfully", HttpStatus.OK);
    }
    

}