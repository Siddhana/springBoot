package com.godspeed.effectiveJava;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReportTest {
    
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        Apple a = new Apple(new Date(), 1000);
        Apple b = new Apple(new Date(), 1000);
        Apple c = new Apple(new Date(), 1000);
        apples.add(a);
        apples.add(b);
        apples.add(c);
        
        Map<Integer, Integer> monthQty = new LinkedHashMap<>();
        
        for (Apple apple : apples) {
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int month = localDate.getMonthValue();
            if (monthQty.containsKey(month)) {
                int sum = monthQty.get(month) + apple.getQty();
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : monthQty.entrySet()) {
            
        }
        
    }
    
}
