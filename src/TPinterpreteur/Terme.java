package TPinterpreteur;

public class Terme {
    private final String terme;

    public Terme(String terme) {
        this.terme = terme.trim();
    }

    public Evaluation analyseTerme() throws Exception{ //analyse un terme et retourne son résultat
        Evaluation eval;
        String[] parties;
        Facteur facteur;

        if (terme.equals("")) throw new ExpressionErroneeException("Erreur : Expression erronée");

        if (!terme.contains("*") && !terme.contains("/")) { //alors c'est un facteur
            facteur = new Facteur(terme);
            eval = facteur.analyseFacteur();
        }
        else {
            boolean prod = !terme.contains("/") && terme.contains("*") || terme.contains("/") && terme.contains("*") && terme.indexOf("*") < terme.indexOf("/"); //pour savoir si c'est un produit ou un quotient
            parties = terme.split("[/*]", 2); //on partage le terme en 2 parties selon les délimiteurs * ou / dans un tableau (2 indices)
            facteur = new Facteur(parties[0]);
            eval = facteur.analyseFacteur();
            while (parties.length != 1) { //parcours des parties du terme
                if (prod) {
                    prod = !parties[1].contains("/") && parties[1].contains("*") || parties[1].contains("/") && parties[1].contains("*") && parties[1].indexOf("*") < parties[1].indexOf("/");
                    parties = parties[1].split("[/*]", 2);
                    facteur = new Facteur(parties[0]);
                    eval = new Produit(eval, facteur.analyseFacteur());
                } else { //quotient
                    prod = !parties[1].contains("/") && parties[1].contains("*") || parties[1].contains("/") && parties[1].contains("*") && parties[1].indexOf("*") < parties[1].indexOf("/");
                    parties = parties[1].split("[/*]", 2);
                    facteur = new Facteur(parties[0]);

                    eval = new Quotient(eval, facteur.analyseFacteur());
                }
            }
        }
        return eval;
    }
}
