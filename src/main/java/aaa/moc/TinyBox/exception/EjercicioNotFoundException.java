package aaa.moc.TinyBox.exception;

public class EjercicioNotFoundException extends TinyBoxRuntimeException {

  public EjercicioNotFoundException() {
    super();
  }

  public EjercicioNotFoundException(String message) {
    super(message);
  }

  public EjercicioNotFoundException(Throwable cause) {
    super(cause);
  }

  public EjercicioNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  // Constructors with args
  public EjercicioNotFoundException(String[] args) {
    super(args);
  }

  public EjercicioNotFoundException(String message, String[] args) {
    super(message, args);
  }

  public EjercicioNotFoundException(String[] args, Throwable cause) {
    super(args, cause);
  }

  public EjercicioNotFoundException(String message, String[] args, Throwable cause) {
    super(message, args, cause);
  }

  public EjercicioNotFoundException(String message, Throwable cause, String[] args) {
    super(message, cause, args);
  }

}