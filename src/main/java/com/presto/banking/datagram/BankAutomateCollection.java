package com.presto.banking.datagram;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class BankAutomateCollection {
    private static final int CST_MAX_INT = 10;

    private static final int CST_MAX_SIZE = 100000;

    public static Collection automateCollections() {
        // System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        List<UserOrder> fooList = new ArrayList<UserOrder>();
        while ((fooList.size()) < (BankAutomateCollection.CST_MAX_SIZE)) {
            int i = ((int) ((Math.random()) * (BankAutomateCollection.CST_MAX_INT)));
            fooList.add(new UserOrder(i));
        } 
        UserOrder[] foos = new UserOrder[4];
        int[] i = new int[]{ 1, 2, 3, 4 };
        char[] c = new char[]{ 'a', 'b', 'c' };
        foos[0] = new UserOrder("Tom", 45, 80000);
        foos[1] = new UserOrder("Sam", 56, 75000);
        foos[2] = new UserOrder("Alex", 30, 120000);
        foos[3] = new UserOrder("Peter", 25, 60000);
        System.out.println("now sorting list...");
        try {
            Arrays.sort(foos);
            System.out.println(foos.toString());
            System.out.println("successful Arrayssorted by Comparable<T>.");
        } catch (IllegalArgumentException e) {
            System.out.println("boooom! Arrays Sort by Comparable<T> fails, if not consistent with equals.");
        }
        try {
            UserData f = new UserData();
            // Arrays.sort(
            System.out.println("successful Arrays sorted by Comparable<T>.");
        } catch (IllegalArgumentException e) {
            System.out.println("boooom! ArraysSort by Comparable<T> fails, if not consistent with equals.");
        }
        // a) first try sort using Comparable implementation of Foo
        try {
            Collections.sort(fooList);
            System.out.println("successful Collections sorted by Comparable<T>.");
        } catch (IllegalArgumentException e) {
            System.out.println("boooom! Collections Sort by Comparable<T> fails, if not consistent with equals.");
        }
        // b) second try sorting using Comparator implementation of FooComparator
        try {
            Collections.sort(fooList, new UserData());
            System.out.println(new UserData().toString());
            System.out.println("successful Collections sorted by Comparator<T>.");
        } catch (IllegalArgumentException e) {
            System.out.println("boooom! Collections Sort by Comparator<T> fails, if not consistent with equals.");
        }
        return fooList;
    }
}

