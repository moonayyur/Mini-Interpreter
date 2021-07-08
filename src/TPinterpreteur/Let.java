package TPinterpreteur;


public class Let extends Commande{
    private Variable variable;

    Let(String expression)
    {
        super(expression);
    }

    public void analyse() throws Exception {
        final String SEPARATEUR = "=";
        String[] parties = getExpression().split(SEPARATEUR,2);
        String variable=parties[0].replace(" ","");
        variable=variable.trim();
        char premiereLettre=variable.charAt(0);//verifier si la variable commence par une lettre
        //plusieur test needed :
        //supprimer les espaces avant et apres le variable " let      x   =5"
        //si il ya des espaces au milieu de variable "let mo unia = 5"  #erreur
        if(MotsReserves.contains(variable)) throw new NomVariableInvalideException("Erreur : Le nom de la variable est un mot réservé");
        else if ((premiereLettre >= 'A' && premiereLettre <= 'Z') || (premiereLettre>= 'a' && premiereLettre<= 'z'))
        {
            if (parties.length==1) throw new CommandeInvalideException("Erreur : Expression introuvable");
            Expression exp = new Expression(parties[1]);
            exp.analyseExpression();
            this.variable =new Variable(variable,exp.evaluer());
            ajouterVariable();
        }
        else{
            throw new NomVariableInvalideException("Erreur : Le nom de la variable doit commencer par une lettre");
        }


    }
    public void affichageResultat()
    {
        System.out.println("ok");
    }
    public void ajouterVariable()
    {
        Table_de_symboles.ajouterSymbole(variable);

    }
    public Variable getVariable()
    {
        return this.variable;
    }



}
