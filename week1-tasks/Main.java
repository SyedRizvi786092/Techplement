import com.google.gson.JsonObject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Currency Converter!\n");
        int choice;
        do {
            System.out.println("Please select an option:");
            System.out.println("1. Convert currency");
            System.out.println("2. Add currency to the list");
            System.out.println("3. Remove currency from the list");
            System.out.println("4. Display currency list");
            System.out.println("5. Exit");

            // Read user input
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount in USD:");
                    double amount = sc.nextDouble();
                    System.out.println("Enter the currency code:");
                    String currency = sc.next();
                    CurrencyConverter cc = new CurrencyConverter();
                    JsonObject jsonobj = cc.connectAPI();
                    double result = cc.convert(amount, currency, jsonobj);
                    System.out.println("Equivalent amount in " + currency + ": " + result);
                    break;
                case 2:
                    System.out.println("Enter the currency code to add:");
                    String newCurrency = sc.next();
                    CurrencyList.addCurrency(newCurrency);
                    break;
                case 3:
                    System.out.println("Enter the currency code to remove:");
                    String removeCurrency = sc.next();
                    CurrencyList.removeCurrency(removeCurrency);
                    break;
                case 4:
                    System.out.println("Currency list:");
                    String[] currencyList = CurrencyList.getCurrencyList();
                    for (String curr : currencyList) {
                        System.out.println(curr);
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (choice != 5);
    }
}
