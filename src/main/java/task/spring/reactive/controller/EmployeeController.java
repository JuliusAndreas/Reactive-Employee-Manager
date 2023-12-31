package task.spring.reactive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import task.spring.reactive.data.model.Employee;
import task.spring.reactive.data.repository.EmployeeRepository;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable String id) {
        return employeeRepository.findEmployeeById(Integer.parseInt(id));
    }
}
