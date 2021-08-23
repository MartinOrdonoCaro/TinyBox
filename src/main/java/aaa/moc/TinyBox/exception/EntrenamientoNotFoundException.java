package aaa.moc.TinyBox.exception;

public class EntrenamientoNotFoundException extends TinyBoxRuntimeException{
    public EntrenamientoNotFoundException() {
        super();
    }

    public EntrenamientoNotFoundException(String message) {
        super(message);
    }

    public EntrenamientoNotFoundException(Throwable cause) {
        super(cause);
    }

    public EntrenamientoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructors with args
    public EntrenamientoNotFoundException(String[] args) {
        super(args);
    }

    public EntrenamientoNotFoundException(String message, String[] args) {
        super(message, args);
    }

    public EntrenamientoNotFoundException(String[] args, Throwable cause) {
        super(args, cause);
    }

    public EntrenamientoNotFoundException(String message, String[] args, Throwable cause) {
        super(message, args, cause);
    }

    public EntrenamientoNotFoundException(String message, Throwable cause, String[] args) {
        super(message, cause, args);
    }
}
