package TPinterpreteur;
import java.util.*;
public class Table_de_symboles {
    public static Set<Symbole> tableSymbole=new HashSet<Symbole>();
    public static void ajouterSymbole(Symbole symbole)
    {
        tableSymbole.add(symbole);
    }
    public static Symbole rechercherSymbole(String nom)
    {
        Symbole symbole=new Symbole();
        Iterator<Symbole> it=tableSymbole.iterator();
        while(it.hasNext()){
            symbole=it.next();
            if(symbole.getNom()==nom){break;}
        }
        return (symbole);
    }
    public static boolean existanceSymbole(String nom)
    {
        Iterator<Symbole> it=tableSymbole.iterator();
        boolean bool=false;
        while(it.hasNext()){
            if(it.next().getNom()==nom){
                bool=true;
                break;}
            else{ bool=false;}}
        return bool;
    }
   

    
}
