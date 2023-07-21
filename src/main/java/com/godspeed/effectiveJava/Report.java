package com.godspeed.effectiveJava;


public class Report {
    
    private int jan;
    private int feb;
    private int mar;
    private int apr;
    private int may;
    private int jun;
    private int jul;
    private int aug;
    private int sep;
    private int oct;
    private int nov;
    private int dec;
    
    public void setMonthQty(int month, int qty) {
        switch (month) {
            case 1:
                this.setJan(qty);
                break;
            case 2:
                System.out.println("It's Tuesday!");
                break;
            case 3:
                System.out.println("It's Wednesday!");
                break;
            case 4:
                System.out.println("It's Thursday!");
                break;
            case 5:
                System.out.println("It's Friday!");
                break;
            case 6:
                System.out.println("It's Saturday!");
                break;
            case 7:
                System.out.println("It's Sunday!");
                break;
            default:
                System.out.println("Invalid day of the week.");
                break;
        }
    }
    
    public int getJan() {
        return jan;
    }
    
    public void setJan(int jan) {
        this.jan = jan;
    }
    
    public int getFeb() {
        return feb;
    }
    
    public void setFeb(int feb) {
        this.feb = feb;
    }
    
    public int getMar() {
        return mar;
    }
    
    public void setMar(int mar) {
        this.mar = mar;
    }
    
    public int getApr() {
        return apr;
    }
    
    public void setApr(int apr) {
        this.apr = apr;
    }
    
    public int getMay() {
        return may;
    }
    
    public void setMay(int may) {
        this.may = may;
    }
    
    public int getJun() {
        return jun;
    }
    
    public void setJun(int jun) {
        this.jun = jun;
    }
    
    public int getJul() {
        return jul;
    }
    
    public void setJul(int jul) {
        this.jul = jul;
    }
    
    public int getAug() {
        return aug;
    }
    
    public void setAug(int aug) {
        this.aug = aug;
    }
    
    public int getSep() {
        return sep;
    }
    
    public void setSep(int sep) {
        this.sep = sep;
    }
    
    public int getOct() {
        return oct;
    }
    
    public void setOct(int oct) {
        this.oct = oct;
    }
    
    public int getNov() {
        return nov;
    }
    
    public void setNov(int nov) {
        this.nov = nov;
    }
    
    public int getDec() {
        return dec;
    }
    
    public void setDec(int dec) {
        this.dec = dec;
    }
    
}
