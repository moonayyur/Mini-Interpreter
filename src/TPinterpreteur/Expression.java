package TPinterpreteur;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Expression {
    private String expression;
    private Evaluation terme1, terme2;
    private static int num;
    private static Map<Integer,String> sousexpressions;

    public Expression(String expression) {
        this.expression = expression;
    }

    public Evaluation analyseExpression() throws Exception{ //analyse une expression et retourne son résultat
        Evaluation eval;
        String[] parties;
        Terme terme;

        if (expression.equals("")) throw new Exception("Erreur : Expression manquante");

        while (expression.contains("(")){
            String sousExp = analyseParenthese(expression);
            sousexpressions.put(num, sousExp.substring(1, sousExp.length() - 1));  //ajouter la sous expression à la map
            expression = expression.replace(sousExp, "$" + num + "$");
            num++;
        }

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

    private String analyseParenthese(String expression) throws ParentheseManquanteException { //retourne la sous expression entre parenthéses
        int i, begin = i = expression.indexOf("("); //recuperer l'index du premier '('
        Deque<Integer> pile = new ArrayDeque<>();
        pile.add(begin);
        try {
            while (!pile.isEmpty()) { //parcourir la chaine
                i++;
                if (expression.charAt(i) == '(') pile.add(i); //empiler si on trouve '('
                else if (expression.charAt(i) == ')') pile.removeLast(); //depiler si on trouve ')'
            }
            return expression.substring(begin, i + 1);
        } catch (IndexOutOfBoundsException e) {
            throw new ParentheseManquanteException("Erreur : Parenthèse fermante manquante");
        }
    }

    public double evaluer() throws Exception {
        return analyseExpression().evaluer();
    }
}
