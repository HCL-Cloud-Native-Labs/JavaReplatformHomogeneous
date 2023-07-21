package com.presto.banking.daoImpl;
import com.presto.banking.actionForm.Loan_Details;
import com.presto.banking.util.HibernateUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import com.presto.banking.actionForm.Loan_Details;
import com.presto.banking.util.HibernateUtil;
import org.hibernate.HibernateException;
public class Loan_Add2DB_DaoImpl extends HibernateUtil {
    EntityManagerFactory entityManagerFactory = HibernateUtil.getSessionFactory();

    EntityManager entityManager;

    public void addLoan2Mysql(Loan_Details loan) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(loan);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}