public class CreatorExpression extends Creator {
    String Exp;
    public CreatorExpression(String exp){
        this.Exp=exp;
    }
    @Override
    public IEvaluable createEvaluable() {
        return new Expression(Exp);
    }
}
