package com.presto.banking.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadPropertyFile {
    public Properties config() throws IOException {
        Properties prop = new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("config.properties");
        prop.load(is);
        is.close();
        System.out.println(("props:" + prop));
        return prop;
    }

    public static void main(String[] args) throws IOException {
    }
}

