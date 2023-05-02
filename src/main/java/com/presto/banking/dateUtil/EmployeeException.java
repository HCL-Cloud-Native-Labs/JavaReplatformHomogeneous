package com.presto.banking.dateUtil;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;


public class EmployeeException {
    public static void countThrows() throws IOException, SocketException {
        SocketAddress sa = new InetSocketAddress("127.0.0.1", 45678);
        DatagramPacket dp = new DatagramPacket(new byte[1], 1, sa);
        DatagramPacket dp1 = new DatagramPacket(new byte[1], 1, sa);
        try {
            DatagramPacket dp2 = new DatagramPacket(new byte[1], 1, sa);
        } catch (Exception x) {
        }
        DatagramPacket dp3 = new DatagramPacket(new byte[1], 0, 1, sa);
        DatagramPacket dp4 = new DatagramPacket(new byte[1], 0, 1, sa);
        try {
            DatagramPacket dp5 = new DatagramPacket(new byte[1], 0, 1, sa);
        } catch (Exception x) {
        }
    }
}

