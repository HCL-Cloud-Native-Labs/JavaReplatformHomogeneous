package com.presto.banking.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.presto.banking.actionForm.Loan_Details;
import com.presto.banking.util.HibernateUtil;

public class Loan_Add2DB_DaoImpl extends HibernateUtil {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session;

	public void addLoan2Mysql(Loan_Details loan) {

		session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		try {
			session.save(loan);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}