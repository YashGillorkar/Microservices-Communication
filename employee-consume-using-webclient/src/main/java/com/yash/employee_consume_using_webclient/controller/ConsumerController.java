package com.yash.employee_consume_using_webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yash.employee_consume_using_webclient.model.EmployeeDTO;
import com.yash.employee_consume_using_webclient.service.ConsumerServiceI;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/consume")
public class ConsumerController {

    @Autowired
    private ConsumerServiceI consumerServiceI;

    @GetMapping("/getuser/{id}")
    public Mono<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id) {
        return consumerServiceI.getEmployeeById(id);
    }

    @PostMapping("/create")
    public Mono<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return consumerServiceI.createEmployee(employeeDTO);
    }

    @PutMapping("/update/{id}")
    public Mono<EmployeeDTO> updateEmployee(@PathVariable ("id") Long id, @RequestBody EmployeeDTO employeeDTO) {
        return consumerServiceI.updateEmployee(id, employeeDTO);
    }

    @PatchMapping("/patch/{id}")
    public Mono<EmployeeDTO> partiallyUpdateEmployee(@PathVariable ("id") Long id, @RequestBody EmployeeDTO employeeDTO) {
        return consumerServiceI.partiallyUpdateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteEmployee(@PathVariable ("id") Long id) {
        return consumerServiceI.deleteEmployee(id);
    }
}
