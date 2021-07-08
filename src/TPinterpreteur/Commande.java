package TPinterpreteur;

public abstract class Commande {
  private String expression;// l'expression a traiter


  Commande(String expression)
  {
    this.expression=expression;
  }

  abstract public void affichageResultat() throws Exception;// affiche le resultat
  abstract void analyse() throws Exception;

  public String getExpression() {
    return expression;
  }
}

