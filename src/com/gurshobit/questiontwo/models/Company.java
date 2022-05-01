package com.gurshobit.questiontwo.models;

import java.util.concurrent.atomic.AtomicLong;

public class Company {
    private static final AtomicLong cid =new AtomicLong(100000);

    private String companyNumber;

    private String companyName;

    private double companyStockPrice;

    private boolean hasCompanyStockUp;

    public String getCompanyNumber() {
        return companyNumber = companyNumber + cid.incrementAndGet();
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getCompanyStockPrice() {
        return companyStockPrice;
    }

    public void setCompanyStockPrice(double companyStockPrice) {
        this.companyStockPrice = companyStockPrice;
    }

    public boolean isHasCompanyStockUp() {
        return hasCompanyStockUp;
    }

    public void setHasCompanyStockUp(boolean hasCompanyStockUp) {
        this.hasCompanyStockUp = hasCompanyStockUp;
    }
}
