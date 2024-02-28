package com.vancone.playground.thread.sychronized;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class TransactionRecord {
    private String user;
    private Integer balance;
    private Date dateTime;

    public TransactionRecord(String user, Integer balance) {
        this.user = user;
        this.balance = balance == null? 0: balance;
        this.dateTime = new Date();
    }

    public void print() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        String dateStr = simpleDateFormat.format(dateTime);
        System.out.println("User: " + (user == null? "NULL": user) + ", Balance: " + balance + ", Time: " + dateStr);
    }
}
