package exchange;

public interface Expression {
    Money reduce(Bank bank, String to);
}
