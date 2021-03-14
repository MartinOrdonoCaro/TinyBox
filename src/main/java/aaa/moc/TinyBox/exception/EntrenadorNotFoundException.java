package aaa.moc.TinyBox.exception;

public class EntrenadorNotFoundException extends TinyBoxRuntimeException{
    public EntrenadorNotFoundException() {
        super();
    }

    public EntrenadorNotFoundException(String message) {
        super(message);
    }

    public EntrenadorNotFoundException(Throwable cause) {
        super(cause);
    }

    public EntrenadorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructors with args
    public EntrenadorNotFoundException(String[] args) {
        super(args);
    }

    public EntrenadorNotFoundException(String message, String[] args) {
        super(message, args);
    }

    public EntrenadorNotFoundException(String[] args, Throwable cause) {
        super(args, cause);
    }

    public EntrenadorNotFoundException(String message, String[] args, Throwable cause) {
        super(message, args, cause);
    }

    public EntrenadorNotFoundException(String message, Throwable cause, String[] args) {
        super(message, cause, args);
    }
}
