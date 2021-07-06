package TPinterpreteur;

public class Variable extends Symbole implements Evaluation  {
    private double valeur;

    public Variable(String nom){
        super(nom);
        //chercher la valeur dans la table de symbole si la variable existe sinon exception
    }

    public double evaluer() {
        return this.valeur;
    }
    
    
}
