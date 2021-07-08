package TPinterpreteur;

public class Difference implements Evaluation {
    private final Evaluation arg1;
    private final Evaluation arg2;
    public Difference(Evaluation arg1, Evaluation arg2){
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    @Override
    public double evaluer() throws Exception{
        return arg1.evaluer() - arg2.evaluer();
    }
}