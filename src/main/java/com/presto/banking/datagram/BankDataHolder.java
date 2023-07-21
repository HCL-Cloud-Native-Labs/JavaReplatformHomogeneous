package com.presto.banking.datagram;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import sun.security.util.SecurityConstants;
public class BankDataHolder extends SecurityManager {
    public static void dataGramSetting() throws IOException {
        // Constructor
        SocketAddress sa = new InetSocketAddress("127.0.0.1", 45678);
        DatagramSocket socket = new DatagramSocket(sa);
        DatagramSocket socket2 = new DatagramSocket();
        DatagramSocket socket3 = new DatagramSocket() {};
        DatagramPacket dp = new DatagramPacket(new byte[1], 1, sa);
        DatagramPacket dp1 = new DatagramPacket(new byte[1], 1, sa);
        try {
            DatagramPacket dp2 = new DatagramPacket(new byte[1], 1, sa);
        } catch (NullPointerException x) {
            System.out.println("Null pointer exception is thrown");
        }
        DatagramPacket dp3 = new DatagramPacket(new byte[1], 0, 1, sa);
        DatagramPacket dp4 = new DatagramPacket(new byte[1], 0, 1, sa);
        try {
            DatagramPacket dp5 = new DatagramPacket(new byte[1], 0, 1, sa);
        } catch (NullPointerException x) {
            System.out.println("Null pointer exception is thrown");
        }
        socket.setSendBufferSize(20);
        socket.getSendBufferSize();
        socket.setReceiveBufferSize(20);
        socket.getReceiveBufferSize();
        socket.setReuseAddress(true);
        socket.getReuseAddress();
        socket.setBroadcast(false);
        // getBroadcast() method
        socket.getBroadcast();
        // setTrafficClass() method
        socket.setTrafficClass(45);
        socket.getTrafficClass();
        // getChannel() method
        System.out.println("Channel : " + (socket.getChannel() != null ? socket.getChannel() : "null"));
        // setSocketImplFactory() method
        socket.setDatagramSocketImplFactory(null);
        // close() method
        socket.close();
        socket.isClosed();
    }

    @SuppressWarnings("deprecation")
    public void checkSecurity() {
        // set the policy file as the system securuty policy
        System.setProperty("java.security.policy", "file:/C:/java.policy");
        // create a security manager
        BankDataHolder sm = new BankDataHolder();
        // set the system security manager
        System.setSecurityManager(sm);
        // perform the check
        sm.checkPermission(SecurityConstants.CHECK_MEMBER_ACCESS_PERMISSION);
        // sm.checkPermission(perm, context);
        // print a message if we passed the check
    }
}