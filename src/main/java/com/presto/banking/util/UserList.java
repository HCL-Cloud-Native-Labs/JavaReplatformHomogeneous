package com.presto.banking.util;

public class UserList extends java.util.ArrayList {
	
	    private final String additionalItem;

	    UserList(String additionalItems) {
	        this.additionalItem = additionalItems;
	    }

	    @Override
	    public int size() {
	        return super.size() + 1;
	    }
	    
	}


