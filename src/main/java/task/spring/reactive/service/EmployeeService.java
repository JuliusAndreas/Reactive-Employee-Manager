package task.spring.reactive.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import task.spring.reactive.data.dto.InvalidInputException;
import task.spring.reactive.data.model.Employee;
import task.spring.reactive.data.repository.EmployeeRepository;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Mono<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Mono<Employee> addEmployee(final Employee employee) {
        return employeeRepository.save(employee);
    }

    public Mono<Employee> replaceEmployee(Employee employee) {
        if (employee.getId() == null) {
            throw new InvalidInputException("No id was provided to update the employee");
        }
        return employeeRepository.save(employee);
    }

    public Mono<Void> removeEmployee(Long id) {
        return employeeRepository.deleteById(id);
    }
}
