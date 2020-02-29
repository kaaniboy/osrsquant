package command;

/*
Represents the result of a command's execution. It contains
a boolean of whether the command succeeded, as well as an
optional payload.
*/
public class CommandResult<T> {
    private boolean success;
    private T payload;

    private CommandResult(boolean success) {
        this.success = success;
    }

    private CommandResult(boolean success, T payload) {
        this(success);
        this.payload = payload;
    }

    public static CommandResult<Void> success() {
        return new CommandResult<>(true);
    }

    public static CommandResult<Void> fail() {
        return new CommandResult<>(false);
    }

    public static <E> CommandResult<E> successWithPayload(E payload) {
        return new CommandResult<E>(true, payload);
    }

    public static <E> CommandResult<E> failWithPayload(E payload) {
        return new CommandResult<E>(false, payload);
    }

    public boolean isSuccess() {
        return success;
    }

    public T getPayload() {
        return payload;
    }
}
