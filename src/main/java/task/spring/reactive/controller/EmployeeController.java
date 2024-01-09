package task.spring.reactive.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import task.spring.reactive.data.model.Employee;
import task.spring.reactive.service.EmployeeService;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<Mono<Void>> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeService.addEmployee(employee).then());
    }

    @PutMapping
    public ResponseEntity<Mono<Void>> replaceEmployee(@RequestBody Employee employee) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeService.replaceEmployee(employee).then());
    }
}
