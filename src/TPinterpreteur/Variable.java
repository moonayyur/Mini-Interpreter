package TPinterpreteur;

public class Variable extends Symbole implements Evaluation  {
    private double valeur;
    public Variable(String nom,double valeur){
        super(nom);
        this.valeur = valeur;
    }
    public Variable(String nom){
        super(nom);
    }
    public double getValue()
    {
        return valeur;
    }

    public double evaluer() {
        return this.valeur;
    }
    
    
}
