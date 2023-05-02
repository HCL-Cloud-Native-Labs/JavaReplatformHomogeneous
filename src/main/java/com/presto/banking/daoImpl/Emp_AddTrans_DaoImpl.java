package com.presto.banking.daoImpl;


import com.presto.banking.actionForm.Emp_AddTrans;
import com.presto.banking.util.HibernateUtil;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.hibernate.HibernateException;


/**
 *
 *
 * @author VS60001724
 */
public class Emp_AddTrans_DaoImpl extends HibernateUtil {
    EntityManagerFactory entityManagerFactory = HibernateUtil.getSessionFactory();

    EntityManager entityManager;

    /**
     *
     *
     * @param depo
     * 		Employee Deposit Amount
     * @return 
     */
    public Emp_AddTrans deposit(Emp_AddTrans depo) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Emp_AddTrans abc = new Emp_AddTrans();
        String clid = depo.getClid();
        abc.setClid(clid);
        String detail = depo.getDetails();
        abc.setDetails(detail);
        String depos = depo.getAmount();
        abc.setDeposit(depos);
        Date date = new Date();
        date = new Timestamp(date.getTime());
        try {
            String SQL_QUERY = ("SELECT depo.amount FROM Emp_AddTrans depo WHERE depo.clid ='" + clid) + "' ORDER BY depo.id DESC LIMIT 1";
            Query query = entityManager.createQuery(SQL_QUERY);
            @SuppressWarnings("rawtypes")
            List results = query.getResultList();
            try {
                String f_amount = ((String) (results.get(0)));
                System.out.println(results);
                System.out.println(f_amount);
                if (f_amount == null) {
                    abc.setAmount(depos);
                }else {
                    int sa = Integer.parseInt(f_amount);
                    int sb = Integer.parseInt(depos);
                    int xy = sa + sb;
                    String xyz = Integer.toString(xy);
                    abc.setAmount(xyz);
                }
            } catch (Exception e) {
                abc.setAmount(depos);
                System.out.println(e.getMessage());
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            abc.setAmount(depos);
            // session.getTransaction().rollback();
        }
        abc.setCreated(date);
        entityManager.persist(abc);
        entityManager.getTransaction().commit();
        return depo;
    }

    /**
     *
     *
     * @param taken
     * 		Employee Withdraw Amount
     * @return 
     */
    public Emp_AddTrans withdrawn(Emp_AddTrans taken) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Emp_AddTrans abc = new Emp_AddTrans();
        String clid = taken.getClid();
        abc.setClid(clid);
        String detail = taken.getDetails();
        abc.setDetails(detail);
        String withd = taken.getAmount();
        abc.setWithdrawn(withd);
        Date date = new Date();
        date = new Timestamp(date.getTime());
        String SQL_QUERY = ("SELECT taken.amount FROM Emp_AddTrans taken WHERE taken.clid ='" + clid) + "' ORDER BY taken.id DESC LIMIT 1";
        Query query = entityManager.createQuery(SQL_QUERY);
        @SuppressWarnings("rawtypes")
        List results = query.getResultList();
        String f_amount = ((String) (results.get(0)));
        System.out.println(results);
        System.out.println(f_amount);
        int sa = Integer.parseInt(f_amount);
        int sb = Integer.parseInt(withd);
        int xy = sa - sb;
        taken.setTest("yes");
        taken.setPamount(f_amount);
        if ((sa < 1500) || (xy < 1500)) {
            taken.setTest("not");
            entityManager.getTransaction().rollback();
        }else {
            String xyz = Integer.toString(xy);
            taken.setNamount(xyz);
            abc.setCreated(date);
            abc.setAmount(xyz);
            entityManager.persist(abc);
            entityManager.getTransaction().commit();
        }
        return taken;
    }

    /**
     *
     *
     * @param view
     * 		Employee view Client transactions
     * @return 
     */
    @SuppressWarnings("unchecked")
    public List<Emp_AddTrans> list(Emp_AddTrans view) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String clid = view.getClid();
        System.out.println(clid);
        List<Emp_AddTrans> details = null;
        try {
            entityManager.createQuery((("From Emp_AddTrans WHERE clid=" + clid) + ""));
        } catch (HibernateException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
        return details;
    }

    /**
     *
     *
     * @param views
     * 		Employee View Client current Balance
     * @return 
     */
    public Emp_AddTrans getCurrentBal(Emp_AddTrans views) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String clid = views.getClid();
        try {
            String SQL_QUERY = ("SELECT depo.amount FROM Emp_AddTrans depo WHERE depo.clid ='" + clid) + "' ORDER BY depo.id DESC LIMIT 1";
            Query query = entityManager.createQuery(SQL_QUERY);
            @SuppressWarnings("rawtypes")
            List results = query.getResultList();
            String f_amount = ((String) (results.get(0)));
            System.out.println(results);
            System.out.println(f_amount);
            views.setNamount(f_amount);
        } catch (HibernateException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
        return views;
    }
}

