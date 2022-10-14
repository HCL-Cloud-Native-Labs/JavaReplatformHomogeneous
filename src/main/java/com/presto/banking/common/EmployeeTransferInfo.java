package com.presto.banking.common;

import java.awt.AWTKeyStroke;
import java.awt.Frame;
import java.awt.TextField;
import java.util.Set;  

class EmployeeTransferInfo{  
	
public static void focusTraversalKeysSet(){  
    Frame f= new Frame("Welcome to Presto");  
    TextField t1,t2;  
    t1=new TextField("Create User");  
    t1.setBounds(50,100, 200,30);  
    t2=new TextField("user is created");  
    t2.setBounds(50,150, 200,30);  
    f.add(t1); f.add(t2);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
    int arg0 = 0;
	Set<? extends AWTKeyStroke> arg1 = null;
	f.setFocusTraversalKeys(arg0, arg1);
}  
}  