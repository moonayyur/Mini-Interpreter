package TPinterpreteur;

public class Element {
    private String element;
    private Evaluation eval; //nombre ou variable ou fonction

    public Element(String element) {
        this.element = element;
    }

    public Evaluation analyseElement() throws Exception{ //analyse un element et retourne son résultat
        Evaluation eval;
        String[] parties;

        if (element.equals("")) throw new Exception("Erreur : Expression erronée");

        if (element.matches("\\d.,+")) { //alors c'est un nombre
            return new Nombre(Double.parseDouble(element));
        }
        /*else if (element.substring(0,1).matches("[a-zA-Z]")){ //alors c'est une variable (+ N'EST PAS UNE FCT NI UNE CMD)
            return new Variable(element);
        }
        else if (){ //alors c'est une
        }*/
        return new Nombre(Double.parseDouble(element)); //just to ne7i l'erreur TEMPORAIRE
    }
}
