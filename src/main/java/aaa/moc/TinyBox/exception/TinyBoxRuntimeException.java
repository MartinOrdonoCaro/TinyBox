package aaa.moc.TinyBox.exception;


import aaa.moc.TinyBox.utils.ExceptionUtils;
import lombok.Getter;

@Getter
public class TinyBoxRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 4582447316194662740L;

    private final String[] args;

    public boolean isPrintStacktrace() {
        return false;
    }

    // Default constructors without args
    public TinyBoxRuntimeException() {
        super();
        this.args = new String[]{};
    }

    public TinyBoxRuntimeException(String message) {
        super(ExceptionUtils.processMessage(message));
        this.args = new String[]{};
    }

    public TinyBoxRuntimeException(Throwable cause) {
        super(cause);
        this.args = new String[]{};
    }

    public TinyBoxRuntimeException(String message, Throwable cause) {
        super(ExceptionUtils.processMessage(message), cause);
        this.args = new String[]{};
    }

    // Constructors with args
    public TinyBoxRuntimeException(String[] args) {
        super();
        this.args = args;
    }

    public TinyBoxRuntimeException(String message, String[] args) {
        super(ExceptionUtils.processMessage(message, args));
        this.args = args;
    }

    public TinyBoxRuntimeException(String[] args, Throwable cause) {
        super(cause);
        this.args = args;
    }

    public TinyBoxRuntimeException(String message, String[] args, Throwable cause) {
        super(ExceptionUtils.processMessage(message, args), cause);
        this.args = args;
    }

    public TinyBoxRuntimeException(String message, Throwable cause, String[] args) {
        super(ExceptionUtils.processMessage(message, args), cause);
        this.args = args;
    }

}