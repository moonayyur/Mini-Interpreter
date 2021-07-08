package TPinterpreteur;

public class Fonction extends Symbole implements Evaluation {
    private final Fonction_Standard type;
    private final Evaluation contenu;
    public Fonction(String nom,Evaluation contenu) throws ExpressionErroneeException{
        super(nom);
        if (!Fonction_Standard.contains(nom)) throw new ExpressionErroneeException("Erreur : Nom de fonction invalide");
        type=Fonction_Standard.getType(nom);
        this.contenu = contenu;
    }
    @Override
    public double evaluer() throws Exception{
        final double c=contenu.evaluer();
        switch (type){
            case abs -> {
                return Math.abs(c);
            }
            case cos -> {
                return Math.cos(c);
            }
            case sin -> {
                return Math.sin(c);
            }
            case sqrt -> {
                if (c>=0)
                    return Math.sqrt(c);
                else throw new ArgumentFonctionInvalideException("Erreur : La racine ne peut pas avoir un nombre negatif");
            }
            case log -> {
                if (c>0)
                    return Math.log(c);
                else throw new ArgumentFonctionInvalideException("Erreur : Log ne peut pas avoir un nombre negatif ou nul");
            }
            case tan -> {
                return Math.tan(c);
            }
            default -> {
                return 0;
            }
        }
    }
}

