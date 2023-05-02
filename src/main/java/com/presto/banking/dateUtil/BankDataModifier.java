package com.presto.banking.dateUtil;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class BankDataModifier {
    public static List strailingStrip() {
        List bigDecimalRange = new ArrayList();
        // create 4 BigDecimal objects
        BigDecimal bgStartValueForBatch;
        BigDecimal bgEndValueForBatch;
        BigDecimal bg3;
        BigDecimal bg4;
        bgStartValueForBatch = new BigDecimal("0.00000");
        bgEndValueForBatch = new BigDecimal("23500000.0000");
        // assign the result of stripTrailingZeros method to bg3, bg4
        bg3 = bgStartValueForBatch.stripTrailingZeros();
        bg4 = bgEndValueForBatch.stripTrailingZeros();
        bigDecimalRange.add(bg3);
        bigDecimalRange.add(bg4);
        return bigDecimalRange;
    }
}

