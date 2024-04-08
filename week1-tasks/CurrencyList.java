public class CurrencyList {
    private static String[] currencyList = {"USD"};

    public static String[] getCurrencyList() {
        return currencyList;
    }

    public static void addCurrency(String currency) {
        String[] newCurrencyList = new String[currencyList.length + 1];
        for (int i = 0; i < currencyList.length; i++) {
            newCurrencyList[i] = currencyList[i];
        }
        newCurrencyList[currencyList.length] = currency;
        currencyList = newCurrencyList;
    }

    public static void removeCurrency(String currency) {
        String[] newCurrencyList = new String[currencyList.length - 1];
        int j = 0;
        for (int i = 0; i < currencyList.length; i++) {
            if (!currencyList[i].equals(currency)) {
                newCurrencyList[j] = currencyList[i];
                j++;
            }
        }
        currencyList = newCurrencyList;
    }
}
