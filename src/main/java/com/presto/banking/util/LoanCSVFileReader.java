package com.presto.banking.util;


import com.presto.banking.actionForm.Loan_Details;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;
import javax.jms.JMSException;
import org.json.JSONException;



public class LoanCSVFileReader implements Serializable {
    private static final long serialVersionUID = -5198666908856120180L;

    public ArrayList ReadCSV() throws IOException {
        Properties prop = new ReadPropertyFile().config();
        ArrayList loan = new ArrayList();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
			/* This block is modified by the ADCloud tool to include the use of AWS-S3 service */ 
			Properties awscloudconfigProperties = new Properties();
			java.io.InputStream awsinputStream = getClass().getClassLoader().getResourceAsStream("awscloudconfig.properties");
			awscloudconfigProperties.load(awsinputStream);
			br= new BufferedReader(new java.io.InputStreamReader(com.amazonaws.services.s3.AmazonS3ClientBuilder.standard().withRegion(awscloudconfigProperties.get("aws.region").toString()).build().getObject(awscloudconfigProperties.get("aws.s3.bucketName").toString(), awscloudconfigProperties.get("aws.s3.object").toString()).getObjectContent()))
			/* End of the change by the ADCloud tool for AWS-S3 service */ 
			;
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

    public void producer(ArrayList<Loan_Details> loanDetails) throws JMSException, JSONException, IOException /* This block is modified by the ADCloud tool to include the use of AWS-SQS service */{new com.awssupport.util.AWSUtil().sqsProducer(loanDetails);
		/* End of the change by the ADCloud tool for AWS-SQS service */
		;
    }

    public void consumer() throws JMSException, IOException /* This block is modified by the ADCloud tool to include the use of AWS-SQS service */{new com.awssupport.util.AWSUtil().sqsConsumer();
		/* End of the change by the ADCloud tool for AWS-SQS service */
		;
    }
}