package View;

import Model.Currency;
import Model.Money;

public interface DialogMenu {
    public Money getMoney();
    public Currency getCurrencyTO();
    public void refreshMoney(Money m);
}
