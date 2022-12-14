package com.presto.banking.daoImpl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import com.presto.banking.actionForm.Bank_Detail;
import com.presto.banking.dao.IBank_Detail_DAO;
import com.presto.banking.util.HibernateUtil;

/**
 * @author VS60001724
 *
 */
public class Bank_Detail_DaoImpl extends HibernateUtil implements IBank_Detail_DAO{
	

	@SuppressWarnings("unchecked")
		public List<Bank_Detail> list()  {
	         
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        
	        List<Bank_Detail> details = null;
	        
	        try 
	        {
	             
	            details = (List<Bank_Detail>)session.createQuery("from Bank_Detail").list();
	             
	        } 
	        catch (HibernateException e) 
	        {
	            e.printStackTrace();
	            session.getTransaction().rollback();
	        }
	        
	        session.getTransaction().commit();
	        return details;
	    }

		public Bank_Detail addBank(Bank_Detail add)
		{
			
			return add;
		}
	
}
