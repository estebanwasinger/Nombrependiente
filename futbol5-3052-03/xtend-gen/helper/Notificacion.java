package helper;

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
  
  private String _subject;
  
  public String getSubject() {
    return this._subject;
  }
  
  public void setSubject(final String subject) {
    this._subject = subject;
  }
  
  private String _content;
  
  public String getContent() {
    return this._content;
  }
  
  public void setContent(final String content) {
    this._content = content;
  }
}
