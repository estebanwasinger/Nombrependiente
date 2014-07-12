package ar.edu.futbol5.excepciones;

@SuppressWarnings("all")
public class BusinessException extends RuntimeException {
  public BusinessException(final String msg) {
    super(msg);
  }
}
