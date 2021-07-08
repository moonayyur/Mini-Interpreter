package TPinterpreteur;

public class Puissance implements Evaluation {
    private final Evaluation arg;
    private final Evaluation puiss;
    public Puissance(Evaluation arg, Evaluation puiss){
        this.arg = arg;
        this.puiss = puiss;
    }
    @Override
    public double evaluer() throws Exception{
        return Math.pow(arg.evaluer(), puiss.evaluer());
    }
}
