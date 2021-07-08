package TPinterpreteur;

public class Variable extends Symbole implements Evaluation  {
    private double valeur;
    public Variable(String nom,double valeur)throws Exception{
        super(nom);
        if(nom.contains(" ")) throw new NomVariableInvalideException("Erreur : Nom de variable invalide");
        this.valeur = valeur;
    }

    public double evaluer() {
        return this.valeur;
    }


}

