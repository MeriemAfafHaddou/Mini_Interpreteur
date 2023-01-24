import java.beans.Expression;
import java.util.HashMap;

public class Interpreteur {
    public HashMap<String,Double> table;
    public GestionSaisie gestion;
    public ICommande cmd;
    public IEvaluable eval;
    public void interpreter(){}
    public Variable creerVariable(String nom, Double valeur){
        return null;
    }
    public Expression creerCommande(){
        return null;
    }
    public Fonction creerFonction(){
        return null;
    }
    public Expression creerExpression(){
        return null;
    }
    public boolean executerCommande(){
        return false;
    }
}
