public class TestList {
    public static void main(String[] args) {
        System.out.println("Default currency list:");
        String[] currencyList = CurrencyList.getCurrencyList();
        for (String currency : currencyList) {
            System.out.println(currency);
        }
        CurrencyList.addCurrency("EUR");
        CurrencyList.addCurrency("JPY");
        CurrencyList.addCurrency("CAD");
        System.out.println("After adding three currencies:");
        currencyList = CurrencyList.getCurrencyList();
        for (String currency : currencyList) {
            System.out.println(currency);
        }
        CurrencyList.removeCurrency("JPY");
        System.out.println("After removing JPY:");
        currencyList = CurrencyList.getCurrencyList();
        for (String currency : currencyList) {
            System.out.println(currency);
        }
    }
}
