package TPinterpreteur;

public class Fonction extends Symbole implements Evaluation {
    private double resultat;
    private Fonction_Standard type;
    private Evaluation contenu;
    public Fonction(String nom,double resultat,Fonction_Standard type,Evaluation contenu) {
        super(nom);
        this.resultat = resultat;
        this.type = type;
        this.contenu = contenu;
    }
    @Override
    public double evaluer() {
        return 0;
    }
}

