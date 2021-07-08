package TPinterpreteur;

public class Interpreteur {
    private String ligneDeCommande;
    public String[] lireLigneDeCommande()
    {
        return ligneDeCommande.split(" ",2);
    }
    public Commande trouverCommande() throws CommandeInvalideException
    {
        Commande commande;
        String[] ligneDeCommandeDepartage =lireLigneDeCommande();
        if(ligneDeCommandeDepartage.length==1) throw new CommandeInvalideException("Erreur : Commande incomplete");
        if (ligneDeCommandeDepartage[0].equals("print"))
            commande=new Print(ligneDeCommandeDepartage[1]);

        else if  (ligneDeCommandeDepartage[0].equals("let"))
            commande=new Let(ligneDeCommandeDepartage[1]);

        else
            throw new CommandeInvalideException("Erreur : Commande inexistante");

        return commande;
    }

    public void setLigneDeCommande(String ligneDeCommande) {
        this.ligneDeCommande = ligneDeCommande.trim();
    }

    public boolean getLigneDeCommande(String str) {
        return ligneDeCommande.equals(str);
    }
}
