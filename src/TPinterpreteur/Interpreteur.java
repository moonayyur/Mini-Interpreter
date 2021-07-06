package TPinterpreteur;

import java.util.*;
public class Interpreteur {
    private static String ligneDeCommande;
    public static Set<String> motsReserves=new HashSet<String>();
    private static String[] lireLigneDeCommande()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez vos commandes, tapez end pour terminer votre programe");
        ligneDeCommande = sc.nextLine();
        final String SEPARATEUR = " ";
        String parties[] = ligneDeCommande.split(SEPARATEUR);
        return parties;
       
    }
    static public Commande trouverCommande() throws CommandeInvalideException
    {
        Commande commande;
        String ligneDeCommandeDepartage[]=lireLigneDeCommande();
        if (ligneDeCommandeDepartage[0].equals("print"))
        {
           commande=new Print(ligneDeCommandeDepartage[1]);
        }
        else if  (ligneDeCommandeDepartage[0].equals("let"))
        {
            commande=new Let(ligneDeCommandeDepartage[1]);
        }
        else{
            throw new CommandeInvalideException("commande inexistante");
        }
        return commande;
    }
    public static void main(String[] args) {
        motsReserves.add("sin");
        motsReserves.add("cos");
        motsReserves.add("tan");
        motsReserves.add("abs");
        motsReserves.add("sqrt");
        motsReserves.add("log");
        motsReserves.add("print");
        motsReserves.add("let");
        try{
            Commande commande=Interpreteur.trouverCommande();
            Class c = commande.getClass();
            if (c.getName().equals("Let"))
            {
                ((Let)commande).analyse();
                //on analyse l'expression apres variable
               // ((Let)commande).ajouterVariable();
               ((Let)commande).affichageResultat();   
            }
            else{
                System.out.println("je suis un print");
            }
           
        }
        catch (CommandeInvalideException e)
        {
            System.out.println(e);
        }
        catch (NomVariableInvalideException e)
        {
            System.out.println(e);
        }
        
        
    }


    
}

