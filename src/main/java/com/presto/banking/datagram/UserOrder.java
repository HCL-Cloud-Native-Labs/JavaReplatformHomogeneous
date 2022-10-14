package com.presto.banking.datagram;

public class UserOrder implements Comparable<UserOrder> {
	private int orderId = 0;
	private String string;
	private int j;

	public UserOrder(int orderId) {
		this.orderId = orderId;
	}

	public UserOrder() {
		// TODO Auto-generated constructor stub
	}

	public UserOrder(String string, int orderId, int j) {
		// TODO Auto-generated constructor stub
		this.orderId = orderId;
		this.string = string;
		this.j = j;
	}

	public int getOrderId() {
		return orderId;
	}

	@Override
	public String toString() {
		return orderId + "" + string + "" + j + "";
	}

	public int compareTo(UserOrder o) {
		if (this.orderId < o.getOrderId()) {
			return -1;
		}
		return 1;
	}

}
