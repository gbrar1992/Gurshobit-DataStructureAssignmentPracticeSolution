package com.gurshobit.questiontwo;

import com.gurshobit.questiontwo.data.CompaniesDatabase;
import com.gurshobit.questiontwo.models.Company;
import com.gurshobit.questiontwo.services.StockService;

import java.util.Scanner;
import java.util.TreeMap;

public class Home {

    public static int userChoice = 0;
    public static CompaniesDatabase companiesDatabase = new CompaniesDatabase();
    public static Scanner scannerInput = new Scanner(System.in);
    public static TreeMap<Double, Company>  companiesTreeMap = companiesDatabase.companiesList();

    public static StockService stockService = new StockService();

    public static void main(String[] args) {
        homeMenu();
    }

    public static void homeMenu(){
        do {
            System.out.println("----------------------");
            System.out.println("Welcome to Small Stocks Agency");
            System.out.println("----------------------");
            System.out.println("Select from Options Below:");
            System.out.println("1. Add Company Stocks");
            System.out.println("2. Display Companies stock prices in ascending order");
            System.out.println("3. Display Companies stock prices in descending order");
            System.out.println("4. Display Number of Companies whose stock prices rose today");
            System.out.println("5. Display Number of Companies whose stock prices declined today");
            System.out.println("6. Search a Stock Price");
            System.out.println("7. Exit");
            userChoice = Integer.parseInt(scannerInput.nextLine()); // Main \n
            switch (userChoice) {
                case 1:
                    System.out.println("Enter Number of Companies");
                    int companiesNumber = Integer.parseInt(scannerInput.nextLine());
                    for(int c = 0; c < companiesNumber; c++){
                        String companyName;
                        do {
                            System.out.println("Enter Company Name:");
                            companyName = scannerInput.nextLine();
                        } while(companyName.length() == 0);

                        System.out.println("Enter Stock Price of Company (" + companyName+")");
                        double companyStockPrice = Double.parseDouble(scannerInput.nextLine());
                        System.out.println("Whether "+companyName+"'s stock price rose today compare to yesterday");
                        boolean isStockUp = scannerInput.nextLine().equals("true");

                        Company company = new Company();
                        company.setCompanyNumber("");
                        company.setCompanyName(companyName);
                        company.setCompanyStockPrice(companyStockPrice);
                        company.setHasCompanyStockUp(isStockUp);

                        companiesTreeMap.put(companyStockPrice,company);
                    }
                    goToMenuConfirmation();
                    break;

                case 2:
                    System.out.println("Companies stock prices in ascending order");
                    if(companiesTreeMap.size() > 0) {
                        String[] companies = stockService.stocksAll(companiesTreeMap,"ASC");
                        for (String company : companies) {
                            System.out.print(company + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("No Companies Exists to display");
                    }

                    goToMenuConfirmation();
                    break;

                case 3:
                    System.out.println("Companies stock prices in descending order");
                    if(companiesTreeMap.size() > 0) {
                        String[] companies = stockService.stocksAll(companiesTreeMap,"DESC");
                        for (int k = companies.length; k > 0; k--){
                            System.out.print(companies[k-1] + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("No Companies Exists to display");
                    }
                    goToMenuConfirmation();
                    break;
                case 4:
                    System.out.println("Number of Companies whose stock prices rose today: " + stockService.stocksToday(companiesTreeMap,"rose"));
                    goToMenuConfirmation();
                    break;

                case 5:
                    System.out.println("Number of Companies whose stock prices decline today: " + stockService.stocksToday(companiesTreeMap,"decline"));
                    goToMenuConfirmation();
                    break;

                case 6:
                    System.out.println("Enter Stock Price want to search");
                    double stockPriceValue = Double.parseDouble(scannerInput.nextLine());

                    if(companiesTreeMap.containsKey(stockPriceValue)){
                        Company companyStock = companiesTreeMap.get(stockPriceValue);
                        System.out.println("Stock of " + companyStock.getCompanyName() + " with price " + stockPriceValue + " is found");
                    } else {
                        System.out.println("Stock not found");
                    }
                    goToMenuConfirmation();
                    break;

            }

        } while(userChoice != 7);
    }

    public static void goToMenuConfirmation(){
        System.out.println("Do you want to goto homepage (1. Yes/2. No)?");
        int userInput = Integer.parseInt(scannerInput.nextLine());
        if(userInput == 1){
            homeMenu();
        } else{
            System.out.println("Thank you for having stocks with us!!");
            System.exit(0);
        }
    }

}
