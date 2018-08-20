package exchange;

public class Bank {
    Money reduce(Expression expression, String to) {
        return expression.reduce(to);
    }
}
