import java.beans.Expression;
import java.util.HashMap;

/** Creator **/
public class Interpreteur {
    public HashMap<String,Double> table;
    public GestionSaisie gestion;
    public Commande cmd;
    public IEvaluable eval;
    public void interpreter(){
        while(!(gestion.saisir()).equals("end")) //boucle afin d'interpreter les commandes, "end" pour quitter.
        {
            executerCommande(gestion.saisir()); //methode executer de l'interpreteur
        }
    }
    public boolean executerCommande(String ligne){
        cmd = creerCommande(ligne);
        String instruction = gestion.extraireCmd();
        String evaluable = gestion.extraireEval();
        if(instruction.equals("print")){
            Print print = new Print();
            print.evaluer();
        } else if (instruction.equals("let")) {
            Let let = new Let();
            let.evaluer();
        }
        return false;
    }
    public IEvaluable creerEvaluable(){
        return eval;
    }
    public Commande creerCommande(String ligne){
        return new Commande(ligne);
    }

}
