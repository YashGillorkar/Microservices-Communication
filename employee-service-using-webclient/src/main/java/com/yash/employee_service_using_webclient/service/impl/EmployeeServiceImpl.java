package com.yash.employee_service_using_webclient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.employee_service_using_webclient.entity.Employee;
import com.yash.employee_service_using_webclient.exception.InvalidIdException;
import com.yash.employee_service_using_webclient.model.EmployeeRequestDTO;
import com.yash.employee_service_using_webclient.model.EmployeeResponseDTO;
import com.yash.employee_service_using_webclient.repository.EmployeeRepository;
import com.yash.employee_service_using_webclient.service.EmployeeServiceI;

import org.springframework.transaction.annotation.Transactional; // Use Spring's @Transactional

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeResponseDTO saveEmployeeDetails(EmployeeRequestDTO entity) {
		Employee emp = convertDTOtoEmployee(entity);
		return convertToDTO(employeeRepository.save(emp));
	}

	@Override
	@Transactional(readOnly = true)
	public EmployeeResponseDTO fetchEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new InvalidIdException("Invalid ID Exception: " + id));
		return convertToDTO(employee);
	}

	@Override
	public void deleteEmployeeDetails(Long id) {
		if (!employeeRepository.existsById(id)) {
			throw new InvalidIdException("Invalid Id " + id);
		}
		employeeRepository.deleteById(id);
	}
	
	@Override
	@Transactional
	public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO entity) {
	    Employee employee = employeeRepository.findById(id)
	            .orElseThrow(() -> new InvalidIdException("Invalid ID: " + id));

	    employee.setName(entity.getName());
	    employee.setSalary(entity.getSalary());
	    employee.setDepartment(entity.getDepartment());

	    return convertToDTO(employeeRepository.save(employee));
	}

	@Override
	@Transactional
	public EmployeeResponseDTO partiallyUpdateEmployee(Long id, EmployeeRequestDTO entity) {
	    Employee employee = employeeRepository.findById(id)
	            .orElseThrow(() -> new InvalidIdException("Invalid ID: " + id));

	    if (entity.getName() != null) {
	        employee.setName(entity.getName());
	    }
	    if (entity.getSalary() != null) {
	        employee.setSalary(entity.getSalary());
	    }
	    if (entity.getDepartment() != null) {
	        employee.setDepartment(entity.getDepartment());
	    }

	    return convertToDTO(employeeRepository.save(employee));
	}


	private EmployeeResponseDTO convertToDTO(Employee employee) {
		return new EmployeeResponseDTO(employee.getId(), employee.getName(), employee.getSalary(),
				employee.getDepartment());
	}

	private Employee convertDTOtoEmployee(EmployeeRequestDTO dto) {
		return new Employee(dto.getName(), dto.getDepartment(), dto.getSalary());
	}
}
