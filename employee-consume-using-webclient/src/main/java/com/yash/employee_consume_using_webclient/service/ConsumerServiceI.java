package com.yash.employee_consume_using_webclient.service;

import com.yash.employee_consume_using_webclient.model.EmployeeDTO;
import reactor.core.publisher.Mono;

public interface ConsumerServiceI {
	Mono<EmployeeDTO> getEmployeeById(Long id);

	Mono<EmployeeDTO> createEmployee(EmployeeDTO employeeDTO);

	Mono<EmployeeDTO> updateEmployee(Long id, EmployeeDTO employeeDTO);

	Mono<EmployeeDTO> partiallyUpdateEmployee(Long id, EmployeeDTO employeeDTO);

	Mono<Void> deleteEmployee(Long id);
}
