package itispaleocapa.gherardid;

public class Partecipante implements java.io.Serializable {
  private static int next_code = 0;
  private String nome;
  private String cognome;
  private int eta;
  private char sesso;
  private int codice;

  public Partecipante(String nome, String cognome, int eta, char sesso) {
    this.nome = nome;
    this.cognome = cognome;
    this.eta = eta;
    this.sesso = sesso;
    setCodice();
  }

  public String toString() {
    return codice + " " + nome + " " + cognome + " " + eta + " " + sesso;
  }

  //setter
  private void setCodice() {
    codice = next_code;
    next_code++;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public void setEta(int eta) {
    this.eta = eta;
  }

  public void setSesso(char sesso) {
    this.sesso = sesso;
  }

  //getter
  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public int getEta() {
    return eta;
  }

  public char getSesso() {
    return sesso;
  }

  public int getCodice() {
    return codice;
  }
}
