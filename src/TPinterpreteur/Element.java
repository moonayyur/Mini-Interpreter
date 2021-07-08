package TPinterpreteur;

public class Element {
    private final String element;

    public Element(String element) {
        this.element = element.trim();
    }

    public Evaluation analyseElement() throws Exception{ //analyse un element et retourne son résultat
        String[] parties;
        if (element.equals("")) throw new ExpressionErroneeException("Erreur : Expression erronée");
        else if (element.contains(")")) throw new ParentheseManquanteException("Erreur : Paranthèse ouvrante manquante");
        if (element.matches("[\\d,.]+")) { //alors c'est un nombre
            if(2*element.length()-element.replace(",","").length()-element.replace(".","").length()>1)
                throw new Exception("Erreur : Le nombre ne doit pas contenir plus d'une seule virgule");
            return new Nombre(Double.parseDouble(element.replace(",",".")));
        }
        else if (element.startsWith("$") && element.endsWith("$")) { //alors c'est une sous expression
            int num = Integer.parseInt(element.replace("$",""));
            Expression exp = new Expression(num);
            return exp.analyseExpression();
        }
        else if (element.contains("$")) { //alors c'est une fonction ou invalide
            if(element.matches("\\d+")) throw new ExpressionErroneeException("Erreur : Operateur manquant");
            if(element.contains("\\d")) throw new ExpressionErroneeException("Erreur : Le nom de fonction ne doit pas contenir un nombre");
            parties = element.split("[$]", 2);
            int num = Integer.parseInt(parties[1].replace("$",""));
            if (!Fonction_Standard.contains(parties[0])) throw new NomVariableInvalideException("Erreur : Nom de fonction introuvable");
            Expression exp = new Expression(num);
            return new Fonction(parties[0], exp.analyseExpression());
        }
        else  { //alors c'est une variable
            if(element.contains(" "))  throw new VariableIntrouvableException("Erreur : Nom de variable invalide");
            if (MotsReserves.contains(element)) throw new VariableIntrouvableException("Erreur : La fonction a besoin de parametres");
            if (!element.substring(0,1).matches("[a-zA-Z]"))  throw new VariableIntrouvableException("Erreur : La variable doit commencer par une lettre");
            if (!Table_de_symboles.existanceSymbole(element)) throw new VariableIntrouvableException("Erreur : Variable introuvable");

            return  (Variable)Table_de_symboles.rechercherSymbole(element);
        }

    }
}
