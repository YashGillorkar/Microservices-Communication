package com.yash.employee_service_using_webclient.service;

import com.yash.employee_service_using_webclient.model.EmployeeRequestDTO;
import com.yash.employee_service_using_webclient.model.EmployeeResponseDTO;

public interface EmployeeServiceI {

	EmployeeResponseDTO saveEmployeeDetails(EmployeeRequestDTO entity);

	EmployeeResponseDTO fetchEmployeeById(Long id);

	void deleteEmployeeDetails(Long id);
	
	EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO entity);

	EmployeeResponseDTO partiallyUpdateEmployee(Long id, EmployeeRequestDTO entity);


}
