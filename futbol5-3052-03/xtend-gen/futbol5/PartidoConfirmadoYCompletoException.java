package futbol5;

@SuppressWarnings("all")
public class PartidoConfirmadoYCompletoException extends RuntimeException {
  private String message;
  
  public PartidoConfirmadoYCompletoException(final String msg) {
    this.message = msg;
  }
}
