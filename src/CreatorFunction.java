public class CreatorFunction extends Creator {
    @Override
    public IEvaluable createEvaluable() {
        return new Fonction();
    }
}
