package com.presto.banking.daoImpl;
import com.presto.banking.actionForm.Bank_Detail;
import com.presto.banking.dao.IBank_Detail_DAO;
import com.presto.banking.util.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import com.presto.banking.actionForm.Bank_Detail;
import com.presto.banking.dao.IBank_Detail_DAO;
import com.presto.banking.util.HibernateUtil;
import org.hibernate.HibernateException;
/**
 *
 *
 * @author VS60001724
 */
public class Bank_Detail_DaoImpl extends HibernateUtil implements IBank_Detail_DAO {
    EntityManagerFactory entityManagerFactory = HibernateUtil.getSessionFactory();

    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Bank_Detail> list() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Bank_Detail> details = null;
        try {
            entityManager.createQuery("from Bank_Detail");
        } catch (HibernateException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
        return details;
    }

    public Bank_Detail addBank(Bank_Detail add) {
        return add;
    }
}