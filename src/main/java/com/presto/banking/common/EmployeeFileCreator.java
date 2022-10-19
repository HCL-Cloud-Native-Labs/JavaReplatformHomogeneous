package com.presto.banking.common;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/* This example source code demonstrates the use of  
isFile() method of File class.
 */
public class EmployeeFileCreator {
    public static File fileCheck() {
        // initialize File object
        File file = new File("D://VisibilityCheckReference.txt");
        // check if it is a file
        boolean result = file.isFile();
        System.out.println(result);
        if (result) {
            // read the contents of the file
            try {
                Scanner s = new Scanner(file);
                while (s.hasNextLine()) {
                    System.out.println(s.nextLine());
                } 
                s.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else
            System.out.println("False");

        return file;
    }
}