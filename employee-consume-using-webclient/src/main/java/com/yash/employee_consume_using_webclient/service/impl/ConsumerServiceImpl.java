package com.yash.employee_consume_using_webclient.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.yash.employee_consume_using_webclient.model.EmployeeDTO;
import com.yash.employee_consume_using_webclient.service.ConsumerServiceI;

import reactor.core.publisher.Mono;

@Service
public class ConsumerServiceImpl implements ConsumerServiceI {

    private final WebClient webClient;

    public ConsumerServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<EmployeeDTO> getEmployeeById(Long id) {
        return webClient.get()
                .uri("/api/{id}", id) 
                .retrieve()
                .onStatus(status -> status.is4xxClientError(),
                        response -> Mono.error(new RuntimeException("Client error: Invalid request")))
                .onStatus(status -> status.is5xxServerError(),
                        response -> Mono.error(new RuntimeException("Server error: Try again later")))
                .bodyToMono(EmployeeDTO.class)
                .doOnError(e -> System.err.println("Error fetching employee: " + e.getMessage()));
    }

    @Override
    public Mono<EmployeeDTO> createEmployee(EmployeeDTO employeeDTO) {
        return webClient.post()
                .uri("/api")
                .bodyValue(employeeDTO)
                .retrieve()
                .bodyToMono(EmployeeDTO.class)
                .doOnError(e -> System.err.println("Error creating employee: " + e.getMessage()));
    }

    @Override
    public Mono<EmployeeDTO> updateEmployee(Long id, EmployeeDTO employeeDTO) {
        return webClient.put()
                .uri("/api/{id}", id)
                .bodyValue(employeeDTO)
                .retrieve()
                .bodyToMono(EmployeeDTO.class)
                .doOnError(e -> System.err.println("Error updating employee: " + e.getMessage()));
    }

    @Override
    public Mono<EmployeeDTO> partiallyUpdateEmployee(Long id, EmployeeDTO employeeDTO) {
        return webClient.patch()
                .uri("/api/{id}", id)
                .bodyValue(employeeDTO)
                .retrieve()
                .bodyToMono(EmployeeDTO.class)
                .doOnError(e -> System.err.println("Error patching employee: " + e.getMessage()));
    }

    @Override
    public Mono<Void> deleteEmployee(Long id) {
        return webClient.delete()
                .uri("/api/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnError(e -> System.err.println("Error deleting employee: " + e.getMessage()));
    }
}
