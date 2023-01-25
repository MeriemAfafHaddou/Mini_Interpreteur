public class InterpreteurFonction extends Interpreteur {
    /** Concrete Creator **/
    public IEvaluable creerEvaluable(){
        return new Fonction();
    }
}
