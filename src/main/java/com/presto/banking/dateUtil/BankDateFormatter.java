package com.presto.banking.dateUtil;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class BankDateFormatter {
    public static String getDefaultDateFormat() {
        // Locale.setDefault(new Locale("cs", "CZ"));
        Date batchStdate = new Date(2018, 0, 1);
        SimpleDateFormat formatter = new SimpleDateFormat("EEEEE MMMMM yyyy HH:mm:ss.SSSZ", new Locale("cs", "CZ"));
        String strDate = formatter.format(batchStdate);
        return strDate;
    }
}

