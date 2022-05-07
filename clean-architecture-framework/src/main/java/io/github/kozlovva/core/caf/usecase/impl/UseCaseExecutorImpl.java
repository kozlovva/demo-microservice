package io.github.kozlovva.core.caf.usecase.impl;

import io.github.kozlovva.core.caf.exception.DomainException;
import io.github.kozlovva.core.caf.usecase.UseCase;
import io.github.kozlovva.core.caf.usecase.UseCaseExecutor;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UseCaseExecutorImpl implements UseCaseExecutor {

    private final Validator validator;

    public UseCaseExecutorImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <Command, Result> Result execute(UseCase<Command, Result> useCase, Command command) {
        validate(command);
        return useCase.execute((Command) command);
    }

    @Override
    public <Command> void validate(Command command) {
        var c  = validator.validate(command);
        if (c.isEmpty())
            return;

        String message = c.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

        throw new DomainException(message);
    }
}
