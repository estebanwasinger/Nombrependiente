package futbol5;

@SuppressWarnings("all")
public class EquipoConfirmadoYCompleto extends RuntimeException {
  private String message;
  
  public EquipoConfirmadoYCompleto(final String msg) {
    this.message = msg;
  }
}
