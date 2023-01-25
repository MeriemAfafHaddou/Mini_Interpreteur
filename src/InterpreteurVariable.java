public class InterpreteurVariable extends Interpreteur{
    /** Concrete Creator **/
    public IEvaluable creerEvaluable(){
        return new Variable();
    }
}
