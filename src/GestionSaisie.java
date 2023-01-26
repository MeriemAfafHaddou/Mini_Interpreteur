import java.util.Scanner;

public class GestionSaisie {
    protected int pos = -1, ch;
    protected String str ;
    public String saisir() {
        Scanner sc= new Scanner(System.in);
        System.out.print(">>> ");
        this.str = sc.nextLine() ;
        return this.str;
    }
    private void charSuiv() {
        this.ch = (++this.pos < str.length()) ? str.charAt(this.pos) : -1 ;
    }
    public String extraireCmd() {
        this.pos=-1;
        charSuiv();
        while (this.ch >= 'a' && this.ch <= 'z' ) charSuiv();
        String command  =  str.substring(0, this.pos); ;
        if(!command.equals("print") && !command.equals("let"))  return null;
        return command ;
    }

    public String extraireExp() {
        this.pos = -1 ;
        extraireCmd() ;
        if(this.ch != ' '){
            return null;
        }
        else return str.substring(this.pos, str.length());

    }
}
