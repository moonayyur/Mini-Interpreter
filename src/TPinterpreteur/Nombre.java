package TPinterpreteur;

public class Nombre implements Evaluation{
    private final double nb;
    public Nombre(double nb){
        this.nb = nb;
    }
    @Override
    public double evaluer() {
        return nb;
    }
}
