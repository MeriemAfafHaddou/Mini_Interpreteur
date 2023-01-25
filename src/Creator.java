abstract class Creator {
  public double  evaluate(){
      IEvaluable eva= createEvaluable();
      return eva.evaluer();
  }

  public abstract IEvaluable createEvaluable();
}
