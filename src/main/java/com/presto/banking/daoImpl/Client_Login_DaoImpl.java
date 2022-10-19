package com.presto.banking.daoImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.presto.banking.actionForm.Client_Login;
import com.presto.banking.actionForm.Client_LoginMan;
import com.presto.banking.util.HibernateUtil;
/**
 *
 *
 * @author VS60001724
 */
public class Client_Login_DaoImpl extends HibernateUtil implements ModelDriven<Object> , SessionAware {
    private Map<String, Object> usersession;
    
    EntityManagerFactory entityManagerFactory = HibernateUtil.getSessionFactory();
	EntityManager entityManager;
	
    /**
     *
     *
     * @param login
     * 		Client Login
     * @return 
     */
    public Client_Login checkLogin(Client_Login login) {
        usersession = ActionContext.getContext().getSession();
        entityManager = entityManagerFactory.createEntityManager();
        String userName = null;
        String password = null;
        String bank_id = null;
        userName = login.getUserName();
        password = login.getPassword();
        bank_id = login.getBank_id();
        password = md5(password);
        String SQL_QUERY = ((((("SELECT login FROM Client_Login login WHERE login.userName = '" + userName) + "' AND login.password = '") + password) + "' AND login.bank_id = '") + bank_id) + "'";
        try {
            System.out.println(SQL_QUERY);
             entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(SQL_QUERY);
            @SuppressWarnings("rawtypes")
            Iterator it = query.getResultList().iterator();
            if (it.hasNext()) {
                login = ((Client_Login) (it.next()));
                Client_LoginMan da = new Client_LoginMan();
                da.setBank_id(bank_id);
                System.out.println("From DA:" + da.getBank_id());
                Date date = new Date();
                date = new Timestamp(date.getTime());
                System.out.println(date);
                da.setCreated(date);
                entityManager.persist(da);
                entityManager.getTransaction().commit();
                 entityManager.getTransaction().begin();
                String SQL_QUERY1 = ("SELECT depo.created FROM Client_LoginMan depo WHERE depo.bank_id ='" + bank_id) + "' ORDER BY depo.id DESC";
                Query query1 = entityManager.createQuery(SQL_QUERY1);
                @SuppressWarnings("rawtypes")
                List results = query1.getResultList();
                try {
                    String se = results.get(1).toString();
                    usersession.put("user2", se);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                login.setBank_id(null);
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
        return login;
    }

    /**
     *
     *
     * @param chpw
     * 		Client Change Password
     * @return 
     */
    public Client_Login changepw(Client_Login chpw) {
        usersession = ActionContext.getContext().getSession();
        String abcd = ((String) (usersession.get("user1")));
        System.out.println("From DAOIMPL Class:" + abcd);
        String test = null;
        test = chpw.getOldpw();
        test = md5(test);
        String test2 = null;
        test2 = chpw.getNewpw();
        test2 = md5(test2);
        entityManager = entityManagerFactory.createEntityManager();
         entityManager.getTransaction().begin();
        String SQL_QUERY = ((("SELECT chpw.password FROM Client_Login chpw WHERE chpw.bank_id ='" + abcd) + "' AND chpw.password='") + test) + "' ";
        try {
            Query query = entityManager.createQuery(SQL_QUERY);
            @SuppressWarnings("rawtypes")
            List results = query.getResultList();
            String f_amount = ((String) (results.get(0)));
            System.out.println(f_amount);
            if (f_amount != null) {
                chpw.setTest("good");
                String SQL_QUERY2 = "UPDATE Client_Login chpw set chpw.password = :password WHERE chpw.bank_id = :abcd";
                Query query2 = entityManager.createQuery(SQL_QUERY2);
                query2.setParameter("password", test2);
                query2.setParameter("abcd", abcd);
                int result = query2.executeUpdate();
                System.out.println("Rows affected: " + result);
            } else {
                chpw.setTest("not");
            }
        } catch (Exception e) {
            chpw.setTest("not");
            System.out.println(e.getMessage());
        }
        entityManager.getTransaction().commit();
        return chpw;
    }

    public void setSession(Map<String, Object> arg0) {
    }

    public Object getModel() {
        return null;
    }
}