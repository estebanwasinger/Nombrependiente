package observers;

@SuppressWarnings("all")
public class Notificacion {
  private String _from;
  
  public String getFrom() {
    return this._from;
  }
  
  public void setFrom(final String from) {
    this._from = from;
  }
  
  private String _to;
  
  public String getTo() {
    return this._to;
  }
  
  public void setTo(final String to) {
    this._to = to;
  }
  
  private String _message;
  
  public String getMessage() {
    return this._message;
  }
  
  public void setMessage(final String message) {
    this._message = message;
  }
  
  private String _title;
  
  public String getTitle() {
    return this._title;
  }
  
  public void setTitle(final String title) {
    this._title = title;
  }
}
