package io.github.kozlovva.core.caf.usecase;

public interface UseCaseExecutor {
    <Command, Result> Result execute(UseCase<Command, Result> useCase, Command command);
    <Command> void validate(Command command);
}
