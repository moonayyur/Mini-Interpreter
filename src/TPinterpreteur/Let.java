package TPinterpreteur;


public class Let extends Commande{
    private Variable variable;

    Let(String expression)
    {
        super(expression);
    }

    public void analyse() throws Exception {
        String[] parties = getExpression().split("=",2);
        String variable=parties[0].trim();

        if (parties.length==1)
            throw new CommandeInvalideException("Erreur : Expression invalide");

        if (parties[0].equals(""))
            throw new ExpressionErroneeException("Erreur : Variable manquante");

        if (!variable.substring(0,1).matches("[a-zA-Z]"))
            throw new NomVariableInvalideException("Erreur : Le nom de la variable doit commencer par une lettre");

        if(MotsReserves.contains(variable))
            throw new NomVariableInvalideException("Erreur : Le nom de la variable est un mot réservé");

        Expression exp = new Expression(parties[1]);
        exp.analyseExpression();
        this.variable =new Variable(variable,exp.evaluer());
        ajouterVariable();


    }
    public void affichageResultat()
    {
        System.out.println("ok");
    }
    public void ajouterVariable()
    {
        Table_de_symboles.ajouterSymbole(variable);
    }

}
