package aaa.moc.TinyBox.exception;

public class ActividadNotFoundException extends TinyBoxRuntimeException{
    public ActividadNotFoundException() {
        super();
    }

    public ActividadNotFoundException(String message) {
        super(message);
    }

    public ActividadNotFoundException(Throwable cause) {
        super(cause);
    }

    public ActividadNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructors with args
    public ActividadNotFoundException(String[] args) {
        super(args);
    }

    public ActividadNotFoundException(String message, String[] args) {
        super(message, args);
    }

    public ActividadNotFoundException(String[] args, Throwable cause) {
        super(args, cause);
    }

    public ActividadNotFoundException(String message, String[] args, Throwable cause) {
        super(message, args, cause);
    }

    public ActividadNotFoundException(String message, Throwable cause, String[] args) {
        super(message, cause, args);
    }
}
