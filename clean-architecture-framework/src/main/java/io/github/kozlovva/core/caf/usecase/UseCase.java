package io.github.kozlovva.core.caf.usecase;

public interface UseCase<Command, Result> {

    Result execute(Command command);

}
