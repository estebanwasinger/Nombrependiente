package helper;

@SuppressWarnings("all")
public class Notificacion {
  private String _de;
  
  public String getDe() {
    return this._de;
  }
  
  public void setDe(final String de) {
    this._de = de;
  }
  
  private String _a;
  
  public String getA() {
    return this._a;
  }
  
  public void setA(final String a) {
    this._a = a;
  }
  
  private String _asunto;
  
  public String getAsunto() {
    return this._asunto;
  }
  
  public void setAsunto(final String asunto) {
    this._asunto = asunto;
  }
  
  private String _contenido;
  
  public String getContenido() {
    return this._contenido;
  }
  
  public void setContenido(final String contenido) {
    this._contenido = contenido;
  }
  
  public Notificacion(final String NDe, final String NA, final String NAsunto, final String NContenido) {
    this.setDe(NDe);
    this.setA(NA);
    this.setAsunto(NAsunto);
    this.setContenido(NContenido);
  }
}
