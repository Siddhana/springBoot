package com.godspeed.guava;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Test {
    
    public static void main(String[] args) {
        // LocalDate d = LocalDate.of(2022, 10, 10);
        // int wk = countWeek(d);
        // System.out.println(wk);
        // String test = "GOPR9482ObjDet" + "_" +
        // "ab798d7b-443e-4358-8d59-7616a991acff";
        String test = "GOPR9482ObjDet";
        String[] tests = test.split("_");
    }
    
    public static int countWeek(LocalDate time) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        LocalDate oldRuleDay = LocalDate.of(2021, 12, 31);
        if (time.isEqual(oldRuleDay) || time.isBefore(oldRuleDay)) {
            return time.get(weekFields.weekOfYear());
        }
        
        int week = 1;
        LocalDate judgeLast = LocalDate.of(time.getYear(), 12, 29);
        LocalDate lastMonday = LocalDate
                .of(time.getYear(), 12, 1)
                .with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
        if (time.isEqual(lastMonday)) {
            if (time.isEqual(judgeLast) || time.isAfter(judgeLast)) {
                return week;
            }
        }
        
        LocalDate judgeFirst = LocalDate.of(time.getYear(), 1, 5);
        LocalDate firstMonday = LocalDate
                .of(time.getYear(), 1, 1)
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        if (firstMonday.isAfter(judgeFirst) || firstMonday.isEqual(judgeFirst)) {
            week = 2;
        }
        int count = (int) Duration.between(firstMonday.atStartOfDay(), time.atStartOfDay()).toDays();
        week = week + count / 7;
        return week;
    }
}
