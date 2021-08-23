package aaa.moc.TinyBox.exception;

public class SesionNotFoundException extends TinyBoxRuntimeException{
    public SesionNotFoundException() {
        super();
    }

    public SesionNotFoundException(String message) {
        super(message);
    }

    public SesionNotFoundException(Throwable cause) {
        super(cause);
    }

    public SesionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructors with args
    public SesionNotFoundException(String[] args) {
        super(args);
    }

    public SesionNotFoundException(String message, String[] args) {
        super(message, args);
    }

    public SesionNotFoundException(String[] args, Throwable cause) {
        super(args, cause);
    }

    public SesionNotFoundException(String message, String[] args, Throwable cause) {
        super(message, args, cause);
    }

    public SesionNotFoundException(String message, Throwable cause, String[] args) {
        super(message, cause, args);
    }
}
