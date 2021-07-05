package TPinterpreteur;

public class Expression {
    private String expression;
    private Evaluation terme1, terme2;

    public Expression(String expression) {
        this.expression = expression;
    }

    public Evaluation analyseExpression() throws Exception{ //analyse une expression et retourne son résultat
        Evaluation eval;
        String[] parties;
        Terme terme;

        if (expression.equals("")) throw new Exception("Erreur : Expression manquante");

        /*while (expression.contains("(")) {  //on remplace toutes les expressions entre parentheses par '$<nb>$'
            String sousExp = analyseParenthese(expression);
            sousExpressions.put(nb, sousExp.substring(1, sousExp.length() - 1));  // ajouter la sous expression à la liste

            expression = expression.replace(sousExp, "$" + nb + "$");
            nb++;
            //System.out.println(expression);
        }*/

        if (!expression.contains("+") && !expression.contains("-")) { //alors c'est un terme
            terme = new Terme(expression);
            eval = terme.analyseTerme();
        }
        else {
            boolean somme = !expression.contains("-") && expression.contains("+") || expression.contains("-") && expression.contains("+") && expression.indexOf("+") < expression.indexOf("-"); //pour savoir si c'est une addition ou une soustraction
            parties = expression.split("[-+]", 2); //on partage l'expression en 2 parties selon les délimiteurs + ou - dans un tableau (2 indices)
            if (!somme && parties[0].equals("")){ //si l'expression commence par un -, on partage sa 2eme partie
                somme = !parties[1].contains("-") && parties[1].contains("+") || parties[1].contains("-") && parties[1].contains("+") && parties[1].indexOf("+") < parties[1].indexOf("-");
                parties = parties[1].split("[-+]", 2); //on partage en 2 la partie de l'expression apres le -
                terme = new Terme(parties[0]);
                eval = new Oppose(terme.analyseTerme());
            }
            else { //si c'est une somme ou difference on analyse la 1ere partie de l'expression
                terme = new Terme(parties[0]);
                eval = terme.analyseTerme();
            }
            while (parties.length != 1) { //parcours des parties de l'expression
                if (somme) {
                    somme = !parties[1].contains("-") && parties[1].contains("+") || parties[1].contains("-") && parties[1].contains("+") && parties[1].indexOf("+") < parties[1].indexOf("-");
                    parties = parties[1].split("[-+]", 2);
                    terme= new Terme(parties[0]);
                    eval = new Somme(eval, terme.analyseTerme());
                } else { //difference
                    somme = !parties[1].contains("-") && parties[1].contains("+") || parties[1].contains("-") && parties[1].contains("+") && parties[1].indexOf("+") < parties[1].indexOf("-");
                    parties = parties[1].split("[-+]", 2);
                    terme= new Terme(parties[0]);
                    eval = new Difference(eval, terme.analyseTerme());
                }
            }
        }
        return eval;
    }

    public double evaluer() throws Exception {
        return analyseExpression().evaluer();
    }
}
