package task.spring.reactive.data.repository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import task.spring.reactive.data.model.Employee;

@Repository
public class EmployeeRepository {
    public Mono<Employee> findEmployeeById(Integer id) {
        
    }
}
