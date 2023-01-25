public class InterpreteurExpression extends Interpreteur{
    @Override
    public IEvaluable createEvaluable() {
        return new Expression();
    }
}
