import java.util.function.Function;

public class Fonction implements IEvaluable {
    public String nom;
    private IEvaluable arg;
    @Override
    public double evaluer() {
        Double value=arg.evaluer();
        switch (nom) {
            case "sqrt" : return Math.sqrt(value);
            case "sin" : return Math.sin(Math.toRadians(value));
            case "cos" : return Math.cos(Math.toRadians(value));
            case "tan" : return Math.tan(Math.toRadians(value));
            case "log" : return Math.log(value);
            case "abs" : return Math.abs(value);
            case "exp" : return Math.exp(value);
            default : return 1.0 ;
        }
    }
    public Fonction(String nom, IEvaluable arg){
        this.nom=nom;
        this.arg=arg;
    }
    public Fonction(){};
    public void SetNom(String str){
        this.nom=str;
    }
    public void SetArg(IEvaluable arg){
        this.arg=arg;
    }
}
