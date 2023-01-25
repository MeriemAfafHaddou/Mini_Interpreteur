public class CreatorVariable extends Creator {
    String Nom;
    double valeur;
    public  CreatorVariable(String Nom, double valeur){
        this.Nom=Nom;
        this.valeur=valeur;
    }
    @Override
    public IEvaluable createEvaluable() {
        return new Variable(Nom,valeur);
    }
}
