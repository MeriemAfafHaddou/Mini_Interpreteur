import java.util.Scanner;

public class GestionSaisie {
    public String ligne;
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
}
