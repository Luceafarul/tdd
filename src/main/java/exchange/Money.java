package exchange;

abstract class Money {
    protected int amount;

    abstract Money times(int amount);

    public static Dollar dollar(int amount) {
        return new Dollar(amount);
    }

    public static Franc franc(int amount) {
        return new Franc(amount);
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount && this.getClass().equals(money.getClass());
    }
}
