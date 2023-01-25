public class InterpreteurExpression extends Interpreteur{
    /** Concrete Creator **/
    public IEvaluable creerEvaluable(){
        return new Expression();
    }
}
