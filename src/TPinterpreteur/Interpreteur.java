package TPinterpreteur;

import java.util.*;

public class Interpreteur {
    private static String ligneDeCommande;
    private static String[] lireLigneDeCommande()
    {

        final String SEPARATEUR = " ";
        String parties[] = ligneDeCommande.split(SEPARATEUR,2);
        return parties;

    }
    public static Commande trouverCommande() throws CommandeInvalideException
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez vos commandes, tapez end pour terminer votre programe");
        ligneDeCommande = sc.nextLine();
        ligneDeCommande=ligneDeCommande.trim();
        while(ligneDeCommande.equals("end")==false)
        {
            try{
                Commande commande=Interpreteur.trouverCommande();
                commande.analyse();
                commande.affichageResultat();

            } catch (CommandeInvalideException e)
            {
                System.out.println(e.getMessage());

            } catch (NomVariableInvalideException e)
            {
                System.out.println(e.getMessage());

            } catch (Exception e) {

                System.out.println(e.getMessage());
            } finally
            {
                ligneDeCommande = sc.nextLine();
                ligneDeCommande=ligneDeCommande.trim();
            }
        }
    }
}
