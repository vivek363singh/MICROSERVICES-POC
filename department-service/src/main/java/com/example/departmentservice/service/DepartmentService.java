package com.example.departmentservice.service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;


@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
       
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
   
        return departmentRepository.findByDepartmentId(departmentId);
    }
	/*
	 * public Department updateDepartmentById(Long departmentId) {
	 * 
	 * return departmentRepository. }
	 */

	public List<Department> findAllDepartment() {

		return departmentRepository.findAll();
		
	}

	public void deleteDepartmentById(Long departmentId) {
		
		departmentRepository.deleteById(departmentId);
		
	}
}

