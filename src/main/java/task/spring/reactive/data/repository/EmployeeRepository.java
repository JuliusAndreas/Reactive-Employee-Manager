package task.spring.reactive.data.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import task.spring.reactive.data.model.Employee;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
}
