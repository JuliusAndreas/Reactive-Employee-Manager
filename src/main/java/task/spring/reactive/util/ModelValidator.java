package task.spring.reactive.util;

import jakarta.validation.*;

import java.util.Set;

public class ModelValidator {
    public static void validate(Object target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(target);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
