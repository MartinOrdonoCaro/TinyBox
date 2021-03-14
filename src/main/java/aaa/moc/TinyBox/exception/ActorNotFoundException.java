package aaa.moc.TinyBox.exception;

public class ActorNotFoundException extends TinyBoxRuntimeException{
    public ActorNotFoundException() {
        super();
    }

    public ActorNotFoundException(String message) {
        super(message);
    }

    public ActorNotFoundException(Throwable cause) {
        super(cause);
    }

    public ActorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructors with args
    public ActorNotFoundException(String[] args) {
        super(args);
    }

    public ActorNotFoundException(String message, String[] args) {
        super(message, args);
    }

    public ActorNotFoundException(String[] args, Throwable cause) {
        super(args, cause);
    }

    public ActorNotFoundException(String message, String[] args, Throwable cause) {
        super(message, args, cause);
    }

    public ActorNotFoundException(String message, Throwable cause, String[] args) {
        super(message, cause, args);
    }
}
