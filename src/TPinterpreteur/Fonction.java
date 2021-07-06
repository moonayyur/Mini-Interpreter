package TPinterpreteur;

public class Fonction extends Symbole implements Evaluation {
    private double resultat;
    private Fonction_Standard type;
    private Evaluation contenu;
    public Fonction(String nom,Evaluation contenu) {
        super(nom);
        this.contenu = contenu;
    }
    @Override
    public double evaluer() {
        return 0;
    } /////à changer
}

