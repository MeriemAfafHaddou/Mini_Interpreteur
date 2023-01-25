public class Print implements ICommande{
    private static Creator Expcreator;
    public void executer(String expression){
        Expcreator = new CreatorExpression(expression);
        double valeur=Expcreator.evaluate();
        System.out.println("La valeur est: " + valeur);
    }
}
