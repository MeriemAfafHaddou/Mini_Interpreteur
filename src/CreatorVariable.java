public class InterpreteurVariable extends Interpreteur{
    @Override
    public IEvaluable createEvaluable() {
        return new Variable();
    }
}
