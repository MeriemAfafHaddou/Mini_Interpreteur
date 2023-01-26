import java.util.HashMap;

public class Let implements ICommande{
    private static Creator Varcreator;
    private static Creator Expcreator;


    protected int pos = -1, ch;
    private void nextChar(String str) {
        this.ch = (++this.pos < str.length()) ? str.charAt(this.pos) : -1 ; //recuperer le caractère suivant
    }
    public void executer(String expression){
        int lastPos = 0 ;
        this.pos = -1 ;
        nextChar(expression);
        if (ch==' ') nextChar(expression);
        if (ch >= 'a' && ch <= 'z' || (ch >= 'A' && ch <= 'Z')) { // verifier si la variable commence par un char valide
            while (ch >= 'a' && ch <= 'z' || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')) nextChar(expression);
            String nom = expression.substring(0, this.pos); // recuperer le nom de la variabe
            lastPos = this.pos ;
            while( ch == ' ' || ch == '=' ) nextChar(expression);
            if (expression.substring(lastPos, this.pos).equals(" =") || expression.substring(lastPos, this.pos).equals("= ") || expression.substring(lastPos, this.pos).equals("=")
                    || expression.substring(lastPos, this.pos).equals(" = ") ) // verifier que si bien une affectation valide
            {
                    String str_valeur = expression.substring(this.pos, expression.length()); // recuperer le reste de l'expression afin

                    try {
                         double v=Double.parseDouble(str_valeur);
                         nom=nom.stripLeading();
                        Varcreator = new CreatorVariable(nom,v);
                        Varcreator.evaluate();
                        System.out.println("Ok");

                    } catch (NumberFormatException e){
                        Expcreator = new CreatorExpression(str_valeur);
                        double v=Expcreator.evaluate();
                        Varcreator = new CreatorVariable(nom,v);
                        Varcreator.evaluate();
                        System.out.println("Ok");
                    }


            }
        }
    }
}
