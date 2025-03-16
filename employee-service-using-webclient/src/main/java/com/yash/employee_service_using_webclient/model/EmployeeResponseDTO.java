package com.yash.employee_service_using_webclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponseDTO {
	

	private Long id;
	
	private String name;

	private Double salary;

	private String department;

}
