package excepciones;

@SuppressWarnings("all")
public class BusinessException extends Exception {
  public BusinessException(final String msg) {
    super(msg);
  }
}
