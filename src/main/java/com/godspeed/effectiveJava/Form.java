package com.godspeed.effectiveJava;

import java.util.Date;

public class Form {
    
    private String product;
    private String station;
    private String line;
    private String aoi;
    private Date start;
    private Date end;
    
    public static class Builder {
        private String product;
        private String station;
        private String line;
        private String aoi;
        private Date start;
        private Date end;
        
        public Builder setProduct(String product) {
            this.product = product;
            return this;
        }
        
        public Builder setStation(String station) {
            this.station = station;
            return this;
        }
        
        public Builder setLine(String line) {
            this.line = line;
            return this;
        }
        
        public Builder setAoi(String aoi) {
            this.aoi = aoi;
            return this;
        }
        
        public Builder setStart(Date start) {
            this.start = start;
            return this;
        }
        
        public Builder setEnd(Date end) {
            this.end = end;
            return this;
        }
        
        public Form build() {
            return new Form(this);
        }
    }
    
    private Form(Builder builder) {
        this.product = builder.product;
        this.station = builder.station;
        this.line = builder.line;
        this.aoi = builder.aoi;
        this.start = builder.start;
        this.end = builder.end;
        
    }
    
    public String getProduct() {
        return product;
    }
    
    public String getStation() {
        return station;
    }
    
    public String getLine() {
        return line;
    }
    
    public String getAoi() {
        return aoi;
    }
    
    public Date getStart() {
        return start;
    }
    
    public Date getEnd() {
        return end;
    }
    
}
