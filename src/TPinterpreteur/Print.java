package TPinterpreteur;

public class Print extends Commande{

    private Expression expression;

    Print(String expression)
    {
        super(expression);
        this.expression= new Expression(expression);
    }

    public void affichageResultat() throws Exception
    {
        System.out.println("la valeur est : "+expression.evaluer());
    }
    public void analyse() throws Exception {
        expression.analyseExpression();
    }

}
