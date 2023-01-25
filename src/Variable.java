import java.util.HashMap;

public class Variable implements IEvaluable {
    public String nom;
    public static HashMap<String,Double> table;
    public Double valeur;
    @Override
    public Double evaluer() {
        return valeur;
    }
    public Variable(String nom, Double value){
        this.nom=nom;
        this.valeur=value;
        table.put(nom,value);
    }
    public Variable(){};
    public void SetValue(double value){
        this.valeur=value;
    }
    public void SetNom(String str){
        this.nom=str;
    }
}
