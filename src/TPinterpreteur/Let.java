package TPinterpreteur;

public class Let extends Commande{
    private Variable variable;
    private Expression expression;
    Let(String expression)
    {
        super(expression);
    }
    public void analyse() throws NomVariableInvalideException {
        final String SEPARATEUR = "=";
        String parties[] = super.expression.split(SEPARATEUR);
        String variable=parties[0];
        char premiereLettre=variable.charAt(0);//verifier si la variable commence par une lettre
        if(Interpreteur.contenirVar(variable))
        {
            throw new NomVariableInvalideException("le nom de la variable est un nom reserve");
        }
        else if ((premiereLettre >= 'A' && premiereLettre <= 'Z') || (premiereLettre>= 'a' && premiereLettre<= 'z'))
        {
            this.variable=new Variable(variable);
        }
        else{
            throw new NomVariableInvalideException("le nom de la variable doit commencer par une lettre");
        }


    }
    public void affichageResultat()
    {
        System.out.println("ok");
    }
    public void ajouterVariable()
    {
        Table_de_symboles.ajouterSymbole(this.variable);

    }
    public Variable getVariable()
    {
        return this.variable;
    }


   
}

