package com.gurshobit.questiontwo.services;

import com.gurshobit.questiontwo.models.Company;

import java.util.Iterator;
import java.util.TreeMap;

public class StockService {

    public int stocksToday(TreeMap<Double, Company> companyTreeMap, String stockStatus){
        int counter = 0;
        Iterator<Double> iterator = companyTreeMap.keySet().iterator();
        while(iterator.hasNext()){
            double treeMapKey = iterator.next();
            Company company = companyTreeMap.get(treeMapKey);

            if(stockStatus == "rose" && company.isHasCompanyStockUp()){
                counter++;
            }

            if(stockStatus == "decline" && !company.isHasCompanyStockUp()){
                counter++;
            }
        }

        return counter;
    }

    public String[] stocksAll(TreeMap<Double, Company> companyTreeMap, String orderBy){
        int counter = 0;
        String[] stocksList = new String[companyTreeMap.size()];
        Iterator<Double> iterator = companyTreeMap.keySet().iterator();
        while(iterator.hasNext()) {
            double treeMapKey = iterator.next();
            Company company = companyTreeMap.get(treeMapKey);

            stocksList[counter] = company.getCompanyName() + " (" + company.getCompanyStockPrice()+") ";

            counter++;
        }

        return stocksList;
    }
}
