public class InterpreteurFunction  extends Interpreteur{
    @Override
    public IEvaluable createEvaluable() {
        return new Fonction();
    }
}
