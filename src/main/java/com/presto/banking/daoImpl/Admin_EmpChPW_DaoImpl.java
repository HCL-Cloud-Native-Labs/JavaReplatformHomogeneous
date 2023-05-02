package com.presto.banking.daoImpl;


import com.presto.banking.actionForm.Admin_EmpChPW;
import com.presto.banking.util.HibernateUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.hibernate.HibernateException;


/**
 *
 *
 * @author VS60001724
 */
public class Admin_EmpChPW_DaoImpl extends HibernateUtil {
    EntityManagerFactory entityManagerFactory = HibernateUtil.getSessionFactory();

    EntityManager entityManager;

    /**
     *
     *
     * @param chpw
     * 		Admin Can change Employee password
     * @return 
     */
    public Admin_EmpChPW changepw(Admin_EmpChPW chpw) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String bank_id = chpw.getBank_id();
        String newpw = chpw.getNewpw();
        try {
            String SQL_QUERY2 = "UPDATE Admin_EmpChPW set password = :password WHERE bank_id = :bank_id";
            Query query2 = entityManager.createQuery(SQL_QUERY2);
            query2.setParameter("password", newpw);
            query2.setParameter("bank_id", bank_id);
            int result = query2.executeUpdate();
            System.out.println(("Rows affected: " + result));
        } catch (HibernateException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        System.out.println(bank_id);
        System.out.println(newpw);
        entityManager.getTransaction().commit();
        return chpw;
    }
}

