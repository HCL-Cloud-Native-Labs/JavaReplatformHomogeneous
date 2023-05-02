package com.presto.banking.common;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class PrestoUserException {
    public static void IOExceptionasd() {
        InputStream input = null;
        try {
            input = new FileInputStream("c:\\data\\input-text.txt");
            int data = input.read();
            while (data != (-1)) {
                data = input.read();
            } 
        } catch (IOException e) {
            // do something with e... log, perhaps rethrow etc.
        } finally {
            // TODO Auto-generated catch block
            if (input != null)
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}

