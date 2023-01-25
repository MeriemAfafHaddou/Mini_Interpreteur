import java.beans.Expression;
import java.util.HashMap;

abstract class Interpreteur {
  public void  evaluate(){
      IEvaluable eva= createEvaluable();
      eva.evaluer();
  }
  public abstract IEvaluable createEvaluable();
}
