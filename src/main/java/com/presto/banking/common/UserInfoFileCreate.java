package com.presto.banking.common;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
public class UserInfoFileCreate {
    public static void createFilePath() throws IOException {
        OutputStream os = new FileOutputStream(new File("D:/Mani/Migration/Mani/admininfo.txt"));
        File file = new File("D://users//Migration//users//admininfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);

    }
}