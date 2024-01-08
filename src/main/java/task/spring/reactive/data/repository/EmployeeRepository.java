package task.spring.reactive.data.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import task.spring.reactive.data.model.Employee;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    public Mono<Employee> findEmployeeById(Integer id) {
        
    }

    public List findAllEmployees() {
        return jdbcTemplate.queryForObject("select * from employee", List.class);
    }
}
