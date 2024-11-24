package com.org;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import org.json.JSONObject;

public class Currency_Convertor {

	 // API endpoint
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/0376818ed1dfd84fe76a5450/latest/";

    public static void main(String[] args) {
        // Example usage: Convert 100 USD to EUR
    	Scanner sc=new Scanner(System.in);
    	
        // Prompt user for the currency they want to convert from
        System.out.print("Enter the currency you want to convert from (e.g., INR, USD, EUR, GBP): ");
        String fromCurrency = sc.next().toUpperCase();

        // Prompt user for the currency they want to convert to
        System.out.print("Enter the currency you want to convert to (e.g., INR, USD, EUR, GBP): ");
        String toCurrency = sc.next().toUpperCase();

        System.out.println("Enter amount your to chnage");
        double amount = sc.nextDouble();
        
        try {
            double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
            if (exchangeRate != -1) {
                double convertedAmount = amount * exchangeRate;
                System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
            } else {
                System.out.println("Sorry, could not fetch exchange rate.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get the exchange rate between two currencies
    public static double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        // Construct the API URL with your API key
        String urlString = API_URL + fromCurrency;

        // Make the API request
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        // Read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(response.toString());
        
        // Check if the request was successful
        if (jsonResponse.getString("result").equals("success")) {
            // Extract the exchange rate for the target currency
            JSONObject conversionRates = jsonResponse.getJSONObject("conversion_rates");
            if (conversionRates.has(toCurrency)) {
                return conversionRates.getDouble(toCurrency);
            }
        }

        return -1; // Return -1 if something goes wrong or currency is not found
    }
}
