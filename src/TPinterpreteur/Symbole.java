package TPinterpreteur;
public class Symbole{
    private String nom;
    //private int value;
    Symbole(String nom, int value)
    {
        this.nom=nom;
        //this.value=value;
    }
    Symbole(){}
    public int hashCode()
    {
        return nom.hashCode();
    }
    public boolean equals(Symbole symbole)
    {
        return nom.equals(symbole.getNom());
    }
    public String getNom()
    {
        return nom;
    }
    /* public int getValue()
    {
        return value;
    }*/
    public String toString()
    {
        return nom;
    }
    
}
