package com.presto.banking.daoImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.HibernateException;

import com.presto.banking.actionForm.Admin_AddEmp;
import com.presto.banking.actionForm.Emp_Login;
import com.presto.banking.util.HibernateUtil;
/**
 *
 *
 * @author VS60001724
 */
public class Admin_AddEmp_DaoImpl extends HibernateUtil {
	EntityManagerFactory entityManagerFactory = HibernateUtil.getSessionFactory();
	EntityManager entityManager;
    /**
     *
     *
     * @param addEmp
     * 		Admin Add Employee
     * @return 
     */
    public Admin_AddEmp addEmp(Admin_AddEmp addEmp) {
    	entityManager = entityManagerFactory.createEntityManager();
         entityManager.getTransaction().begin();
        try {
            entityManager.persist(addEmp);
        } catch (HibernateException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
        return addEmp;
    }

    /**
     *
     *
     * @param addEmps
     * 		Admin Add Employee method
     * @return 
     */
    public Emp_Login addEmps(Emp_Login addEmps) {
    	entityManager = entityManagerFactory.createEntityManager();
         entityManager.getTransaction().begin();
        Emp_Login abcd = new Emp_Login();
        String bank_id = addEmps.getBank_id();
        abcd.setBank_id(bank_id);
        String uname = addEmps.getUserName();
        abcd.setUserName(uname);
        String pw = addEmps.getPassword();
        String mpw = md5(pw);
        abcd.setPassword(mpw);
        try {
            entityManager.persist(abcd);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
        return addEmps;
    }
}