package TPinterpreteur;

public class Oppose implements Evaluation {
    private Evaluation ev;
    public Oppose (Evaluation ev){
        this.ev = ev;
    }
    @Override
    public double evaluer() {
        return -ev.evaluer();
    }
}
