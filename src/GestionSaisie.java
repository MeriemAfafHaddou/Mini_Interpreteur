import java.util.Scanner;

public class GestionSaisie {
    public String ligne;
    protected int pos = -1, ch;
    protected String str ;

    public String extraireLigne(){
        return null;
    }
    public Character caractereSuivant(){
        return null;
    }
    public String saisir()  {
        Scanner sc= new Scanner(System.in);
        System.out.print(">>> ");
        this.ligne = sc.nextLine() ;
        return this.ligne;
    }
    private void charSuiv() {
        this.ch = (++this.pos < str.length()) ? str.charAt(this.pos) : -1 ;
    }

    public String extraireCmd() {
        charSuiv();
        while (this.ch >= 'a' && this.ch <= 'z' ) charSuiv();
        String command  =  str.substring(0, this.pos); ;
        if(!command.equals("print") && !command.equals("let")) ;
        return command ;
    }

    public String extraireEval() {
        this.pos = -1;
        extraireCmd();
        if (this.ch != ' ') {// si la commande n'est pas suivie d'un espace exmpl : print5
            return null;
        } else return str.substring(this.pos, str.length());
    }
}
