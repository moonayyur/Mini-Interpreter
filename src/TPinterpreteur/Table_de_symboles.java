package TPinterpreteur;
import java.util.*;

public class Table_de_symboles {
    public static Set<Symbole> tableSymbole=new HashSet<>();
    public static void ajouterSymbole(Symbole symbole)
    {
        if(existanceSymbole(symbole.getNom())) {
            tableSymbole.remove(symbole);
            tableSymbole.add(symbole);
        }
        else
            tableSymbole.add(symbole);
    }
    public static Symbole rechercherSymbole(String nom)
    {
        Symbole symbole=new Symbole();
        Iterator<Symbole> it=tableSymbole.iterator();
        while(it.hasNext()){
            symbole=it.next();
            if(symbole.getNom().equals(nom))
                return symbole;
        }
        return symbole;
    }
    public static boolean existanceSymbole(String nom)
    {
        Iterator<Symbole> it=tableSymbole.iterator();
        while(it.hasNext()) {
            if (it.next().getNom().equals(nom))
                return true;
        }
        return false;
    }



}