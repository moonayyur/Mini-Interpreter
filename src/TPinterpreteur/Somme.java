package TPinterpreteur;

public class Somme implements Evaluation {
    private Evaluation arg1,arg2;
    public Somme(Evaluation arg1, Evaluation arg2){
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    @Override
    public double evaluer() throws Exception{
        return arg1.evaluer() + arg2.evaluer();
    }
}
