package TPinterpreteur;

public class Nombre implements Evaluation{
    private double nb;
    public Nombre(double nb){
        this.nb = nb;
    }
    @Override
    public double evaluer() {
        return nb;
    }
}
