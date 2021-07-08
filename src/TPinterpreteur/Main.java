package TPinterpreteur;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Interpreteur interpreteur= new Interpreteur();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                
                Entrez vos commandes, tapez end pour terminer votre programme
                
                Une commande doit être de la forme:

                let <variable> = <expression>
                ou
                print <expression>
                """);
        interpreteur.setLigneDeCommande(sc.nextLine());
        while(!interpreteur.getLigneDeCommande("end"))
        {
            try {
                Commande commande=interpreteur.trouverCommande();
                commande.analyse();
                commande.affichageResultat();
            }catch (Exception e){
                System.out.println(e.getMessage());
            } finally {
                interpreteur.setLigneDeCommande(sc.nextLine());
            }
        }
    }
}
