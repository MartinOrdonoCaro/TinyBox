package aaa.moc.TinyBox.exception;

public class MedidaNotFoundException extends TinyBoxRuntimeException{
    public MedidaNotFoundException() {
        super();
    }

    public MedidaNotFoundException(String message) {
        super(message);
    }

    public MedidaNotFoundException(Throwable cause) {
        super(cause);
    }

    public MedidaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructors with args
    public MedidaNotFoundException(String[] args) {
        super(args);
    }

    public MedidaNotFoundException(String message, String[] args) {
        super(message, args);
    }

    public MedidaNotFoundException(String[] args, Throwable cause) {
        super(args, cause);
    }

    public MedidaNotFoundException(String message, String[] args, Throwable cause) {
        super(message, args, cause);
    }

    public MedidaNotFoundException(String message, Throwable cause, String[] args) {
        super(message, cause, args);
    }
}
