package sth.core;

public class Criado extends Condition {

  private static Criado instancia;

  protected Criado() {}

  public static Criado instancia() {
    if (instancia == null)
      instancia = new Criado();

    return instancia;
  }
  
  public void open(Survey s) {
	  s.transporte(Aberto.instancia());
  }
  
  public String toString() {
	  return "Criado";
  }
}
