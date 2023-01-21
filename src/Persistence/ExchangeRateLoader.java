package Persistence;

import Model.Currency;
import Model.ExchangeRate;

public interface ExchangeRateLoader {
    public ExchangeRate rateloader(Currency from, Currency to);
}
