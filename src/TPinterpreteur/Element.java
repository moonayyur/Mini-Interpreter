package TPinterpreteur;

public class Element {
    private String element;

    public Element(String element) {
        this.element = element;
    }

    public Evaluation analyseElement() throws Exception{ //analyse un element et retourne son résultat
        String[] parties;

        if (element.equals("")) throw new ExpressionErroneeException("Erreur : Expression erronée");
        else if (element.contains(")")) throw new ParentheseManquanteException("Erreur : Paranthèse ouvrante manquante");
        if (element.matches("\\d.,+")) { //alors c'est un nombre
            return new Nombre(Double.parseDouble(element));
        }
        else if (element.substring(0,1).matches("[a-zA-Z]") && !Fonction_Standard.contains(element) && !element.equals("print") && !element.equals("let")){ //alors c'est une variable
            return new Variable(element);
        }
        else if (element.startsWith("$") && element.endsWith("$")) { //alors c'est une sous expression
            int num = Integer.parseInt(element.replace("$",""));
            Expression exp = new Expression(num);
            return exp.analyseExpression();
        }
        else { //alors c'est une fonction ou invalide
            parties = element.split("[$]", 2);
            int num = Integer.parseInt(parties[1]);
            if (!Fonction_Standard.contains(parties[0])) throw new NomVariableInvalideException("Erreur : Nom de variable invalide");
            Expression exp = new Expression(num);
            return new Fonction(parties[0], exp.analyseExpression());
        }
    }
}
