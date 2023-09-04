package com.vanconeplayground.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

/**
 * @author Tenton Lien
 */
public class DateTest {
    static final int YEAR = 2020;
    static final int MONTH = 11;
    static final int DAY = 13;

    public static void main(String[] args) {
        // Java 1.0
        System.out.println("Java 1.0 API");
        dateAPI();

        // Java 8
        System.out.println("\nJava 8 API");
        LocalDateAPI();

    }

    public static void dateAPI() {
        Date date = new Date(YEAR - 1900, MONTH - 1, DAY);
        System.out.println("Date: " + date.toString());
    }

    public static void LocalDateAPI() {
        LocalDate date = LocalDate.of(YEAR, MONTH, DAY);  // 2020-11-13
        int year = date.getYear();
        Month month = date.getMonth();
        int monthValue = date.getMonthValue();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        System.out.println("LocalDate: " + date.toString());
        System.out.println("Year: " + year);
        System.out.println("Month: " + month + " (" + monthValue + ")");
        System.out.println("Day of Month: " + day);
        System.out.println("Day of Week: " + dow);
        System.out.println("Month Length: " + len);
        System.out.println("Leap Year: " + leap);
    }
}
