package com.poc.pdihexago1.utils;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class FluentValidator {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    private Set<ConstraintViolation<Object>> violations;

    public FluentValidator() {
        this.violations = null;
    }

    // Método para validar um objeto e acumular as falhas de validação
    public <T> FluentValidator validate(T object) {
        this.violations = validator.validate(object);
        return this;  // Retorna o próprio objeto para encadeamento
    }

    // Método para verificar se o objeto é válido
    public boolean isValid() {
        return violations == null || violations.isEmpty();
    }

    // Método para coletar os erros de validação em formato de mensagem
    public String getErrors() {
        if (violations == null || violations.isEmpty()) {
            return "No validation errors.";
        }

        return violations.stream()
                .map(violation -> violation.getPropertyPath() + " " + violation.getMessage())
                .collect(Collectors.joining(", "));
    }

    public String getErrorMessages() {
        if (violations == null || violations.isEmpty()) {
            return "";
        }

        return violations.stream()
                .map(violation -> violation.getMessage())
                .collect(Collectors.joining("\n"));
    }

}
