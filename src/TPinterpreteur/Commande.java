package TPinterpreteur;

public abstract class Commande{
  protected String expression;// l'expression a traiter
    Commande(String expression)
    {
        this.expression=expression;
    }
    Commande(){}
  
    abstract public void affichageResultat();// affiche le resultat
    
}
