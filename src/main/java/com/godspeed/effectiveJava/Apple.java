package com.godspeed.effectiveJava;

import java.util.Date;

public class Apple {
    
    private Date date;
    private int qty;
    
    public Date getDate() {
        return date;
    }
    
    public Apple(Date date, int qty) {
        super();
        this.date = date;
        this.qty = qty;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getQty() {
        return qty;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }
}
