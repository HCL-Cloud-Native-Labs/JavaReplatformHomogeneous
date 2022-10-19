package com.presto.banking.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONException;

import com.presto.banking.actionForm.Loan_Details;
public class LoanCSVFileReader implements Serializable {
    private static final long serialVersionUID = -5198666908856120180L;

    public ArrayList ReadCSV() throws IOException {
        Properties prop = new ReadPropertyFile().config();
        ArrayList loan = new ArrayList();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(prop.get("loan.csvfile").toString()));
            while ((line = br.readLine()) != null) {
                Loan_Details ld = new Loan_Details();
                String[] loanDetails = line.split(cvsSplitBy);
                ld.setName(loanDetails[0]);
                ld.setLoanType(loanDetails[1]);
                ld.setDate(loanDetails[2]);
                ld.setMonthlySalary(loanDetails[3]);
                ld.setLoanAmount(loanDetails[4]);
                // System.out.println("Applicant Name=" + loanDetails[0] + ", Loan Type=" + loanDetails[1]
                // + ", Application Date=" + loanDetails[2] + ", Monthly Income=" + loanDetails[3]
                // + ", Loan Amount=" + loanDetails[4]);
                loan.add(ld);
            } 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return loan;
    }

    public void producer(ArrayList<Loan_Details> loanDetails) throws JMSException, JSONException, IOException {
        System.out.println(loanDetails);
        Properties prop = new ReadPropertyFile().config();
        String url = ActiveMQConnection.DEFAULT_BROKER_URL;
        // prop.get("queue.url");
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection;
        connection = connectionFactory.createConnection();
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES", "*");
        try {
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(prop.get("queue.activemq.name").toString());
            MessageProducer producer = session.createProducer(destination);
            Iterator<Loan_Details> ldIter = loanDetails.iterator();
            while (ldIter.hasNext()) {
                Loan_Details ldValues = ldIter.next();
                System.out.println("Names:" + ldValues.getName());
                Loan_Details ld = new Loan_Details();
                ld.setName(ldValues.getName().toString());
                ld.setLoanType("Financial");
                ld.setDate("03-03-2020");
                ld.setLoanAmount("200000");
                ld.setMonthlySalary("40000");
                ld.setIsEligible("Yes");
                // ld.setLoanType(ldValues.getLoanType().toString());
                // ld.setDate(ldValues.getDate().toString());
                // ld.setLoanAmount(ldValues.getLoanAmount().toString());
                // ld.setMonthlySalary(ldValues.getMonthlySalary().toString());
                // ld.setIsEligible(ldValues.getIsEligible().toString());
                ObjectMessage msgObj = session.createObjectMessage();
                msgObj.setObject(ld);
                producer.send(msgObj);
            } 
            System.out.println("Message has been sent");
        } finally {
            connection.close();
        }
    }

    public void consumer() throws JMSException, IOException {
        Properties prop = new ReadPropertyFile().config();
        String url = ActiveMQConnection.DEFAULT_BROKER_URL;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(prop.get("queue.activemq.name").toString());
        MessageConsumer consumer = session.createConsumer(destination);
        while (consumer.receive() != null) {
            Message message = consumer.receive();
            if (message instanceof ObjectMessage) {
                ObjectMessage textMessage = ((ObjectMessage) (message));
                Loan_Details recdLoanDetail = ((Loan_Details) (textMessage.getObject()));
                // System.out.println("Receiver--:" + recdLoanDetail.getName() + "----" + recdLoanDetail.getLoanType());
            }
        } 
        connection.close();
    }
}