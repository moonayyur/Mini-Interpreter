package TPinterpreteur;

public class Puissance implements Evaluation {
    private Evaluation arg, puiss;
    public Puissance(Evaluation arg, Evaluation puiss){
        this.arg = arg;
        this.puiss = puiss;
    }
    @Override
    public double evaluer() {
        return Math.pow(arg.evaluer(), puiss.evaluer());
    }
}
