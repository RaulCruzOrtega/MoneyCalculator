package money_calculator_final;

import Controler.Command;
import Controler.MCControler;
import Persistence.ExchangeRateLoader;
import Persistence.File.CurrencyLoaderFromFile;
import Persistence.Website.ExchangeRateLoaderFromWebsite;
import View.DialogMenuSwing;
import View.Money_Calculator_View;

public class Money_Calculator_Final {

    public static void main(String[] args) {
        CurrencyLoaderFromFile currencyLoaderFromFile = new CurrencyLoaderFromFile("Currencies.txt");
        ExchangeRateLoader exchangerateloader = new ExchangeRateLoaderFromWebsite();
        DialogMenuSwing dialogmenu = new DialogMenuSwing(currencyLoaderFromFile.loadcurrencies());
        Command command = new MCControler(dialogmenu, exchangerateloader);
        dialogmenu.addCommand("button", command);
        new Money_Calculator_View("Money Calculator", dialogmenu);
    }
}