package com.yash.employee_service_using_webclient.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeRequestDTO {

	@NotNull(message = "Name cannot be empty")
	private String name;

	@Positive(message = "Salary cannot be less than zero")
	private Double salary;

	@NotBlank(message = "Department can not be null")
	private String department;
}
