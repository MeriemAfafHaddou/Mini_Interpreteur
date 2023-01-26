import java.util.HashMap;

public class Variable implements IEvaluable {
    public String nom;
    public static HashMap<String, Double> table = new HashMap<String, Double>();
    public Double valeur;
    @Override
    public double evaluer() {
        return valeur;
    }
    public Variable(String nom, Double value){
        this.nom=nom;
        this.valeur=value;
        table.put(nom,value);
    }
    public Variable(){};
    public void setNom(String nom){
        this.nom=nom;
    }
    public void setValue(double v){
        this.valeur=v;
    }

}
