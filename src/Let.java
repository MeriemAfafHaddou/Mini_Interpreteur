public class Let extends Commande{
    private String expression;
    public Let(String ligne , String expression) {
        super(ligne);
        this.expression = expression.substring(1, expression.length()) ; // (1,~) afin d'eviter l'espace après la commande "print 5"
    }
    public void evaluer() {
        System.out.println("La valeur est: " + IEvaluable.evaluer(expression, table)); //appele a la methode evaluer
    }
}
