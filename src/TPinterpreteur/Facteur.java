package TPinterpreteur;

public class Facteur {
    private String facteur;

    public Facteur(String facteur) {
        facteur=facteur.trim();
        this.facteur = facteur;
    }

    public Evaluation analyseFacteur() throws Exception{ //analyse un facteur et retourne son résultat
        Evaluation eval;
        String[] parties;
        Element element;

        if (facteur.equals("")) throw new ExpressionErroneeException("Erreur : Expression erronée");

        if (!facteur.contains("^")) { //alors c'est un element
            element = new Element(facteur);
            eval = element.analyseElement();
        }
        else {
            parties = facteur.split("[\\^]", 2); //on partage le facteur en 2 parties selon le délimitateur ^ dans un tableau (2 indices)
            element = new Element(parties[0]);
            eval = element.analyseElement();
            while (parties.length != 1) { //parcours des parties du facteur
                    parties = parties[1].split("[\\^]", 2);
                    element = new Element(parties[0]);
                    eval = new Puissance(eval, element.analyseElement());
            }
        }
        return eval;
    }
}
