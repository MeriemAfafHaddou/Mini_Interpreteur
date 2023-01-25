public class Let extends Commande{
    private String expression;
    public Let(String ligne , String expression) {
        super(ligne);
        this.expression = expression.substring(1, expression.length()) ; // (1,~) afin d'eviter l'espace après la commande "print 5"
    }
}
