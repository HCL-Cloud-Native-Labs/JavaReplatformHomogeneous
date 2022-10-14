package com.presto.banking.actionClass;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;

import org.json.JSONException;

import com.opensymphony.xwork2.ActionSupport;
import com.presto.banking.actionForm.Loan_Details;
import com.presto.banking.daoImpl.Loan_Add2DB_DaoImpl;
import com.presto.banking.util.LoanCSVFileReader;


public class Loan_Eligibility_Check_Action extends ActionSupport {
	private static final long serialVersionUID = -4224284910915765989L;

	private LoanCSVFileReader loanCSVFileReader = new LoanCSVFileReader();

	private Loan_Add2DB_DaoImpl loan2mysql = new Loan_Add2DB_DaoImpl();

	private List<Loan_Details> loanList;
	private String[] checkedname;



	public String[] getCheckedname() {
		return checkedname;
	}

	public void setCheckedname(String[] checkedname) {
		this.checkedname = checkedname;
	}

	public String loanfromLocalCSV() throws IOException {
		System.out.println("Reading Local CSV File...");
		ArrayList<Loan_Details> loanDetails = loanCSVFileReader.ReadCSV();
		for (int i = 0; i < (loanDetails.size()); i++)
			if (25000 > (Integer.valueOf(loanDetails.get(i).getMonthlySalary())))
				loanDetails.get(i).setIsEligible("No");
			else
				loanDetails.get(i).setIsEligible("Yes");


		this.setLoanList(loanDetails);
		return SUCCESS;
	}

	public String push2queue() throws IOException, JMSException, JSONException {
		System.out.println("Reading Local CSV File and Push to Queue...");
		ArrayList<Loan_Details> loanDetails = loanCSVFileReader.ReadCSV();
		for (int i = 0; i < (loanDetails.size()); i++)
			if (25000 > (Integer.valueOf(loanDetails.get(i).getMonthlySalary())))
				loanDetails.get(i).setIsEligible("No");
			else
				loanDetails.get(i).setIsEligible("Yes");


		this.setLoanList(loanDetails);
		loanCSVFileReader.producer(loanDetails);
		// loanCSVFileReader.consumer();
		return SUCCESS;
	}

	public String pushSelected2queue() throws IOException, JMSException, JSONException {
		ArrayList<Loan_Details> loanDetails = new ArrayList<Loan_Details>();


		System.out.println(checkedname.length);
		for(String p: checkedname){
			Loan_Details ld = new Loan_Details();
			System.out.println(p);
			ld.setName(p);
			loanDetails.add(ld);
		}

		System.out.println(loanDetails.size());

//		this.setLoanList(loanDetails);
		loanCSVFileReader.producer(loanDetails);
		//        // loanCSVFileReader.consumer();
		return SUCCESS;
	}

	public String push2mysql() throws IOException {
		System.out.println("Read Local CSV file and Push Loan Data to MySql...");
		ArrayList<Loan_Details> loanDetails = loanCSVFileReader.ReadCSV();
		for (int i = 0; i < (loanDetails.size()); i++)
			if (25000 > (Integer.valueOf(loanDetails.get(i).getMonthlySalary())))
				loanDetails.get(i).setIsEligible("No");
			else
				loanDetails.get(i).setIsEligible("Yes");


		for (Loan_Details loan : loanDetails) {
			loan2mysql.addLoan2Mysql(loan);
		}
		this.setLoanList(loanDetails);
		return SUCCESS;
	}

	public List<Loan_Details> getLoanList() {
		return loanList;
	}

	public void setLoanList(List<Loan_Details> loanList) {
		this.loanList = loanList;
	}
}
