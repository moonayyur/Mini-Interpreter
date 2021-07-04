package TPinterpreteur;

public class Produit implements Evaluation {
    private Evaluation arg1,arg2;
    public Produit(Evaluation arg1, Evaluation arg2){
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    @Override
    public double evaluer() {
        return arg1.evaluer() * arg2.evaluer();
    }
}
