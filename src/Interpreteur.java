public class Interpreteur {
    public ICommande cmd;
    public IEvaluable eval;
    public GestionSaisie gestion = new GestionSaisie();
    public void interpreter() {
        while (!gestion.saisir().equals("exit")){
            cmd = new ICommande() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            };
            String instruction = gestion.extraireCmd();
            String expression = gestion.extraireExp();
            if (instruction.equals("print"))
            {
                Print print = new Print() ;
                print.executer(expression); //executer la commande print
            }
            else if (instruction.equals("let"))
            {
                Let let = new Let() ;
                let.executer(expression);//executer la commande let
            }
        }
    }

}
