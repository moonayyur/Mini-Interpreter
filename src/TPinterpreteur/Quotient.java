package TPinterpreteur;

public class Quotient implements Evaluation {
    private Evaluation arg1,arg2;
    public Quotient(Evaluation arg1, Evaluation arg2){
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    @Override
    public double evaluer() throws Exception{
        double c=arg2.evaluer();
        if (c==0) throw new Exception("Erreur : division sur 0");
        return arg1.evaluer() / arg2.evaluer();
    }
}
