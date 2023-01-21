package Controler;

import Model.Currency;
import Model.ExchangeRate;
import Model.Money;
import Persistence.ExchangeRateLoader;
import View.DialogMenu;

public class MCControler implements Command{
    private DialogMenu dialogmenu;
    private ExchangeRateLoader exchangerateloader;
    
    public MCControler(DialogMenu dialogmenu, ExchangeRateLoader exchangerateloader){
        this.dialogmenu = dialogmenu;
        this.exchangerateloader = exchangerateloader;
    }
    
    @Override
    public void execute() {
        Money money = dialogmenu.getMoney();
        if(money != null){
        Currency currencyfrom = money.getCurrency();
        Currency currencyto = dialogmenu.getCurrencyTO();
        ExchangeRate exchangerate = exchangerateloader.rateloader(currencyfrom, currencyto);
        
        Money newmoney = new Money(money.getMount()*exchangerate.getRate(), exchangerate.getTo());
        
        refreshText(newmoney);
        }
    }

    private void refreshText(Money newmoney) {
        dialogmenu.refreshMoney(newmoney);
    }
    
}
