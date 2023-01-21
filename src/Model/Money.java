package Model;

public class Money {
    private double mount;
    private Currency currency;

    public Money(double mount, Currency currency) {
        this.mount = mount;
        this.currency = currency;
    }

    public double getMount() {
        return mount;
    }

    public Currency getCurrency() {
        return currency;
    }
    
    
}
