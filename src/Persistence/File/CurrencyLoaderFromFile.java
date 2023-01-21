package Persistence.File;

import Model.Currency;
import Persistence.CurrencyLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class CurrencyLoaderFromFile implements CurrencyLoader{
    private String FileNameCurrencies;

    public CurrencyLoaderFromFile(String FileNameCurrencies) {
        this.FileNameCurrencies = FileNameCurrencies;
    }

    
    
    @Override
    public List<Currency> loadcurrencies() {
        List<Currency> currencies = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(FileNameCurrencies)));
            IteratorReader iteratorReader = new IteratorReader(reader);
            for (String string : iteratorReader) {
                currencies.add(CreateCurrency(string));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return currencies;
    }

    private Currency CreateCurrency(String string) {
        String[] split = string.split(", ");
        return new Currency(split[0], split[1], split[2]);
    }
    
}
