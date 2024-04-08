// Create an HTTP request to the following URL: https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD
// (replace YOUR-API-KEY with your own API key)
// Parse the JSON response and extract the exchange rates for the following currencies: EUR, GBP, JPY, CAD, AUD, CHF
// Create a method called convert(double amount, String currency) that takes an amount and a currency code as parameters and returns the equivalent amount in USD
// For example, convert(100, "EUR") should return the equivalent amount in USD for 100 EUR
// Test your code by converting the following amounts: 100 EUR, 100 GBP, 100 JPY, 100 CAD, 100 AUD, 100 CHF
// Print the results to the console

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

public class CurrencyConverter {
    public static void main(String[] args) {
        try {
            // Setting URL
            String url_str = "https://v6.exchangerate-api.com/v6/7427f98d814bd63f1f113486/latest/USD";

            // Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader(request.getInputStream()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Testing
            CurrencyConverter cc = new CurrencyConverter();
            System.out.println(cc.convert(100, "INR", jsonobj));

            // Accessing object
            String req_result = jsonobj.get("result").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    double convert(double amount, String currency, JsonObject jsonobj) {
        double rate = 0;
        rate = jsonobj.get("conversion_rates").getAsJsonObject().get(currency).getAsDouble();
        return amount * rate;
    }
}