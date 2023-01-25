public class CreatorVariable extends Creator {
    @Override
    public IEvaluable createEvaluable() {
        return new Variable();
    }
}
