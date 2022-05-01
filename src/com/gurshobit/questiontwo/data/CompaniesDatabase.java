package com.gurshobit.questiontwo.data;

import com.gurshobit.questiontwo.models.Company;

import java.util.TreeMap;

public class CompaniesDatabase {
    public TreeMap<Double, Company> companiesList() {
        Company companyOne = new Company(), companyTwo = new Company() , companyThree = new Company();

        double companyOneStockPrice = 110.25;
        companyOne.setCompanyNumber("");
        companyOne.setCompanyName("Google");
        companyOne.setCompanyStockPrice(companyOneStockPrice);
        companyOne.setHasCompanyStockUp(true);

        double companyTwoStockPrice = 80.78;
        companyTwo.setCompanyNumber("");
        companyTwo.setCompanyName("Facebook");
        companyTwo.setCompanyStockPrice(companyTwoStockPrice);
        companyTwo.setHasCompanyStockUp(false);

        double companyThreeStockPrice = 108.78;
        companyThree.setCompanyNumber("");
        companyThree.setCompanyName("Linkedin");
        companyThree.setCompanyStockPrice(companyThreeStockPrice);
        companyThree.setHasCompanyStockUp(true);

        TreeMap<Double,Company> companyMap = new TreeMap<>();
        companyMap.put(companyOneStockPrice,companyOne);
        companyMap.put(companyTwoStockPrice,companyTwo);
        companyMap.put(companyThreeStockPrice,companyThree);

        return companyMap;
    }
}
