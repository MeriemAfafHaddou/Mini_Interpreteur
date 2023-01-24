public class Variable implements IEvaluable {
    public String nom;
    public Double valeur;
    @Override
    public boolean evaluer() {
        return false;
    }
}
