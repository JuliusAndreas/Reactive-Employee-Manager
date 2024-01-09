package task.spring.reactive.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;
import task.spring.reactive.util.ModelValidator;

@Data
@NoArgsConstructor
public class Employee implements Persistable<Long> {

    @Id
    private Long id;

    @NotBlank(message = "Name can not be empty")
    @NotNull(message = "Name can not be empty")
    @Pattern(regexp = "[a-zA-Z]*", message = "Name can only have letters")
    private String fullName;

    @Digits(integer = 5, fraction = 2, message = "Invalid salary")
    private Double salary;

    @Email(
            message = "Email is not valid",
            regexp =
                    "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|" +
                            "\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\" +
                            "x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9]" +
                            "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\" +
                            "[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|" +
                            "2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08" +
                            "\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @JsonIgnore
    @Transient
    private boolean newEmployee;

    @JsonCreator
    public Employee(@JsonProperty("name") String name, @JsonProperty("salary") Double salary,
                    @JsonProperty("email") String email) {
        this.email = email;
        this.fullName = name;
        this.salary = salary;
        ModelValidator.validate(this);
    }

    @JsonIgnore
    @Override
    @Transient
    public boolean isNew() {
        return this.newEmployee || id == null;
    }

    public Employee setAsNew() {
        this.newEmployee = true;
        return this;
    }

}
