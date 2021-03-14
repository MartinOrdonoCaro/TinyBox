package aaa.moc.TinyBox.exception;

public class UsuarioNotFoundException extends TinyBoxRuntimeException{
    public UsuarioNotFoundException() {
        super();
    }

    public UsuarioNotFoundException(String message) {
        super(message);
    }

    public UsuarioNotFoundException(Throwable cause) {
        super(cause);
    }

    public UsuarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructors with args
    public UsuarioNotFoundException(String[] args) {
        super(args);
    }

    public UsuarioNotFoundException(String message, String[] args) {
        super(message, args);
    }

    public UsuarioNotFoundException(String[] args, Throwable cause) {
        super(args, cause);
    }

    public UsuarioNotFoundException(String message, String[] args, Throwable cause) {
        super(message, args, cause);
    }

    public UsuarioNotFoundException(String message, Throwable cause, String[] args) {
        super(message, cause, args);
    }
}
