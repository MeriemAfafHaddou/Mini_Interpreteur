import java.util.HashMap;

public class Let implements ICommande{


    protected int pos = -1, ch;
    private void nextChar(String str) {
        this.ch = (++this.pos < str.length()) ? str.charAt(this.pos) : -1 ; //recuperer le caractère suivant
    }
    public void executer(String expression){
        int lastPos = 0 ;
        this.pos = -1 ;
        nextChar(expression);
        if (ch >= 'a' && ch <= 'z' || (ch >= 'A' && ch <= 'Z')) { // verifier si la variable commence par un char valide
            while (ch >= 'a' && ch <= 'z' || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')) nextChar(expression);
            String nom = expression.substring(0, this.pos); // recuperer le nom de la variabe
            lastPos = this.pos ;
            while( ch == ' ' || ch == '=' ) nextChar(expression);
            if (expression.substring(lastPos, this.pos).equals(" =") || expression.substring(lastPos, this.pos).equals("= ") || expression.substring(lastPos, this.pos).equals("=")
                    || expression.substring(lastPos, this.pos).equals(" = ") ) // verifier que si bien une affectation valide
            {
                    String str_valeur = expression.substring(this.pos, expression.length()); // recuperer le reste de l'expression afin
                    Expression exp=new Expression();
                    Double value=exp.evaluer();
                    Variable var = new Variable(nom,value);
                    System.out.println("Ok");
            }
        }
    }
}
