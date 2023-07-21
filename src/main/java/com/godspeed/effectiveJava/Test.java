package com.godspeed.effectiveJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
    
    private static final Logger logger = LogManager.getLogger(Test.class);
    
    public static void main(String[] args) {
        // LocalDate now = LocalDate.now().plusDays(5);
        // LocalDate x = new
        // Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(5);
        // if (now.isEqual(x)) {
        // logger.info(777);
        // }
        String test = "P1,P2,P3";
        String[] x = test.split(",");
        for (String a : x) {
            System.out.print(a);
        }
        System.out.print(false);
    }
    
    private static List<String> getMonthName(List<Integer> monthOrders, Map<Integer, String> monthMap) {
        List<String> monthNames = new ArrayList<>();
        monthOrders.forEach(e -> monthNames.add(monthMap.get(e)));
        
        return monthNames;
    }
    
    private static List<Integer> getMonthOrder(int monthValue) {
        List<Integer> monthOrders = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            monthOrders.add(monthValue);
            if (monthValue == 12) {
                monthValue = 1;
                continue;
            }
            monthValue++;
        }
        
        return monthOrders;
    }
    
    private static Integer formatQty(String value) {
        try {
            Double dValue = Double.parseDouble(value);
            Integer iValue = dValue.intValue();
            return iValue;
        } catch (NumberFormatException e) {
            return null;
        }
        
    }
    
    private static String formatWoNo(String value) {
        if (value.equals(""))
            return value;
        
        int idx = 0;
        char[] chars = value.toCharArray();
        if (chars[0] != '0') {
            return value;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                idx = i;
            } else {
                idx++;
                break;
            }
        }
        return value.substring(idx);
    }
    
}
