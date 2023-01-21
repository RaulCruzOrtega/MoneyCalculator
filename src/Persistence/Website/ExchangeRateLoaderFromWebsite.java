package Persistence.Website;

import Model.Currency;
import Model.ExchangeRate;
import Persistence.ExchangeRateLoader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class ExchangeRateLoaderFromWebsite implements ExchangeRateLoader{
    
    
    
    @Override
    public ExchangeRate rateloader(Currency from, Currency to) {
        try {
            URL url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/"+from.getCode().toLowerCase()+"/"+to.getCode().toLowerCase()+".json");
            Gson gson = new Gson();
            
            JsonObject fromJson = gson.fromJson(reader(url), JsonObject.class);
            

            return new ExchangeRate(from, to, fromJson.get(to.getCode().toLowerCase()).getAsDouble());
            
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String reader(URL url) {
        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String text = reader.readLine();
            String next = reader.readLine();
            while (next != null){
                text += next;
                next = reader.readLine();
            }
            return text;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
}
