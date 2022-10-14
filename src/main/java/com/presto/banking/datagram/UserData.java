package com.presto.banking.datagram;

import java.util.Comparator;

public class UserData implements Comparator<UserOrder>  {

	public int compare(UserOrder o1, UserOrder o2) {
		if (o1.getOrderId() < o2.getOrderId()) {
			return -1;
		}
		return 1;
	}

}
