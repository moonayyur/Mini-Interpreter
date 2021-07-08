package TPinterpreteur;

public class Symbole implements Comparable<Symbole>{
    private String nom;
    Symbole(String nom){
        this.nom=nom.trim();
    }
    Symbole(){}
    public int hashCode()
    {
        return nom.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbole symbole)) return false;
        return getNom().equals(symbole.getNom());
    }

    public String getNom()
    {
        return nom;
    }
    public String toString()
    {
        return nom;
    }

    @Override
    public int compareTo(Symbole o) {
        return nom.compareTo(o.nom);
    }
}
