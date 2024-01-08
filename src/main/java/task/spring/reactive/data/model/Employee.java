package task.spring.reactive.data.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private Integer id;
    private String fullName;
}
