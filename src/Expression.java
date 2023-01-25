public class Expression implements IEvaluable {
    public String expr;
    public Expression(String expr){
        this.expr=expr;
    }
    public void setExp(String str){
        this.expr=str;
    }
    @Override
    public Double evaluer() {
            return new Object() {
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
                    } else if (ch >= 'a' && ch <= 'z'|| (ch >= 'A' && ch <= 'Z')) { // functions & variables
                        while (ch >= 'a' && ch <= 'z' || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')) nextChar();
                        String func = expr.substring(startPos, this.pos);
                        Fonction f=new Fonction();
                        f.evaluer();

                    }
                    x=1; // TO BE DELETED
                    if (check('^')) x = Math.pow(x, analyserFacteur()); //exp

                    return x;
                }
            }.analyser();
        }


}
