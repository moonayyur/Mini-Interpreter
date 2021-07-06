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
        else if (element.contains(")")) throw new ParentheseManquanteException("Erreur : Paranthèse ouvrante manquante");
        if (element.matches("\\d.,+")) { //alors c'est un nombre
            return new Nombre(Double.parseDouble(element));
        }
        else if (element.substring(0,1).matches("[a-zA-Z]") && !){ //alors c'est une variable
            return new Variable(element,2);
        }
        else if () { //alors c'est une sous expression
        }
        else { //alors c'est une fonction ou xxxxxx

        }
        return new Nombre(Double.parseDouble(element)); //just to ne7i l'erreur TEMPORAIRE
    }
}
