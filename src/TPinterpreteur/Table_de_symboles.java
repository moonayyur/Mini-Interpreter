package TPinterpreteur;
import java.util.*;

public class Table_de_symboles {
    private static final Set<Symbole> tableSymbole=new HashSet<>();
    public static void ajouterSymbole(Symbole symbole)
    {
        if(existanceSymbole(symbole.getNom())) {
            tableSymbole.remove(symbole);
        }
        tableSymbole.add(symbole);
    }
    public static Symbole rechercherSymbole(String nom)
    {
        Symbole symbole=new Symbole();
        for (Symbole value : tableSymbole) {
            symbole = value;
            if (symbole.getNom().equals(nom))
                return symbole;
        }
        return symbole;
    }
    public static boolean existanceSymbole(String nom)
    {
        for (Symbole symbole : tableSymbole) {
            if (symbole.getNom().equals(nom))
                return true;
        }
        return false;
    }



}