package com.yash.employee_service_using_webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.employee_service_using_webclient.model.EmployeeRequestDTO;
import com.yash.employee_service_using_webclient.model.EmployeeResponseDTO;
import com.yash.employee_service_using_webclient.service.EmployeeServiceI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeServiceI employeeServiceI;

	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> storeEmployeeDetails(@RequestBody @Valid EmployeeRequestDTO entity) {
		EmployeeResponseDTO dto = employeeServiceI.saveEmployeeDetails(entity);
		return new ResponseEntity<EmployeeResponseDTO>(dto, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeDetails(@PathVariable("id") Long id) {
		EmployeeResponseDTO dto = employeeServiceI.fetchEmployeeById(id);
		return new ResponseEntity<EmployeeResponseDTO>(dto, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable ("id") Long id) {
		employeeServiceI.deleteEmployeeDetails(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable ("id")Long id,
			@RequestBody @Valid EmployeeRequestDTO entity) {
		EmployeeResponseDTO updatedEmployee = employeeServiceI.updateEmployee(id, entity);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> partiallyUpdateEmployee(@PathVariable ("id") Long id,
			@RequestBody EmployeeRequestDTO entity) {
		EmployeeResponseDTO updatedEmployee = employeeServiceI.partiallyUpdateEmployee(id, entity);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

}
