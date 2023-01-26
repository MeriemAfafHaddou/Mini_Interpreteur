import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;

/** LE COMPOSITE **/
public class Expression implements IEvaluable {
    private static Creator funcreator;
    private static Creator Varcreator;


    public String expr;
    List<IEvaluable> children = new
            ArrayList<IEvaluable>();
    public void add(IEvaluable eval){
        children.add(eval);
    }
    public void remove(IEvaluable eval){
        children.remove(eval);
    }
    @Override
    public double evaluer(){
        double a=calculer();
        System.out.println(children);
        double result=0;
        for(IEvaluable child:children){
            result+=child.evaluer();
        }
        return result;
    }
    public Expression(String expr){
        this.expr=expr;
    }
    public void setExp(String str){
        this.expr=str;
    }

    public double calculer() {

            return new Object() {
                int y=0;
                int pos = -1, ch;
                void nextChar() {
                    ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
                }

                boolean check(int charToCheck) { //verifier si le ch correspond à un certain char
                    while (ch == ' ') nextChar();
                    if (ch == charToCheck) {
                        nextChar();
                        return true;
                    }
                    return false;
                }

                double analyser(){
                    nextChar();
                    double x = AnalyserExpression(); //methode recursive
                    if (pos < expr.length()) return 0.0 ; //
                    return x;
                }

                double AnalyserExpression() {
                    double x = analyserTerm();
                    for (;;) { // infinte loop until return
                        if      (check('+')) x += analyserTerm(); // addition
                        else if (check('-')) x -= analyserTerm(); // soustraction
                        else return x;
                    }

                }

                double analyserTerm() {
                    double x = analyserFacteur();
                    for (;;) {
                        if      (check('*')) x *= analyserFacteur(); // multiplication
                        else if (check('/')) {
                            try {
                                x /= analyserFacteur();
                            }
                            catch (ArithmeticException e)
                            {
                                System.out.println("Devision par zero !");
                            }
                        }// division
                        else return x ;
                    }
                }

                double analyserFacteur(){
                    System.out.println("hello");
                    if (check('+')) return analyserFacteur(); // plus unair
                    if (check('-')) return -analyserFacteur(); // moins unair

                    double x;
                    int startPos = this.pos;
                    if (check('(')) { // parentheses
                        x = AnalyserExpression();
                        if(!check(')')) ;
                    }  else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(expr.substring(startPos, this.pos));
                        String nom= "y"+Integer.toString(y);
                        y++;
                        Variable v = new Variable(nom,x);
                        children.add(v);
                    } else if (ch >= 'a' && ch <= 'z'|| (ch >= 'A' && ch <= 'Z')) { // functions & variables
                        while (ch >= 'a' && ch <= 'z' || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')) nextChar();
                        String func = expr.substring(startPos, this.pos);
                        int len=expr.length();
                        if(!(func.equals("sqrt") || func.equals("sin") || func.equals("cos") ||
                                func.equals("tan")|| func.equals("log")|| func.equals("abs")|| func.equals("exp"))){//func
                            Variable var=new Variable();
                            if (var.table.containsKey(func)) {
                                x = (double) var.table.get(func);
                                var.setNom(func);
                                var.setValue(x);
                                children.add(var);
                            } else { x=0;}
                        }else {
                            x=analyserFacteur();
                            String newExp=expr.substring(this.pos,len);
                            Expression e=new Expression(newExp);
                            Fonction f = new Fonction(func, e);
                            children.add(f);
                        }
                    }else {x=0;}

                        return x;
                }
            }.analyser();
        }


}
