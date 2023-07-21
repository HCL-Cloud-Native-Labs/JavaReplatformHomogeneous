package com.presto.banking.daoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.presto.banking.actionForm.Admin_Login;
import com.presto.banking.actionForm.Admin_LoginMan;
import com.presto.banking.util.HibernateUtil;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.presto.banking.actionForm.Admin_Login;
import com.presto.banking.actionForm.Admin_LoginMan;
import com.presto.banking.util.HibernateUtil;
import org.apache.struts2.interceptor.SessionAware;
/**
 *
 *
 * @author VS60001724
 */
public class Admin_Login_DaoImpl extends HibernateUtil implements ModelDriven<Object> , SessionAware {
    private Map<String, Object> usersession;

    EntityManagerFactory entityManagerFactory = HibernateUtil.getSessionFactory();

    EntityManager entityManager;

    /**
     *
     *
     * @param login
     * 		Admin Login Method
     * @return 
     */
    public Admin_Login checkLogin(Admin_Login login) {
        entityManager = entityManagerFactory.createEntityManager();
        String userName = null;
        String password = null;
        String bank_id = null;
        userName = login.getUserName();
        password = login.getPassword();
        bank_id = login.getBank_id();
        String SQL_QUERY = ((((("SELECT login FROM Admin_Login login WHERE login.userName = '" + userName) + "' AND login.password = '") + password) + "' AND login.bank_id = '") + bank_id) + "'";
        try {
            System.out.println(SQL_QUERY);
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(SQL_QUERY);
            @SuppressWarnings("rawtypes")
            Iterator it = query.getResultList().iterator();
            if (it.hasNext()) {
                login = ((Admin_Login) (it.next()));
                Admin_LoginMan rr = new Admin_LoginMan();
                rr.setBank_id(bank_id);
                System.out.println("From DA:" + rr.getBank_id());
                Date date = new Date();
                date = new Timestamp(date.getTime());
                rr.setCreated(date);
                entityManager.persist(rr);
                // Saving Last Login
                String SQL_QUERY1 = ("SELECT depo.created FROM Admin_LoginMan depo WHERE depo.bank_id ='" + bank_id) + "' ORDER BY depo.id DESC";
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        entityManager.getTransaction().commit();
        return login;
    }

    /**
     *
     *
     * @param chpw
     * 		Admin Change own password Method
     * @return 
     */
    public Admin_Login changepw(Admin_Login chpw) {
        usersession = ActionContext.getContext().getSession();
        String abcd = ((String) (usersession.get("user1")));
        System.out.println("From DAOIMPL Class:" + abcd);
        String test = null;
        test = chpw.getOldpw();
        String test2 = null;
        test2 = chpw.getNewpw();
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String SQL_QUERY = ((("SELECT chpw.password FROM Admin_Login chpw WHERE chpw.bank_id ='" + abcd) + "' AND chpw.password='") + test) + "' ";
        try {
            Query query = entityManager.createQuery(SQL_QUERY);
            @SuppressWarnings("rawtypes")
            List results = query.getResultList();
            String f_amount = ((String) (results.get(0)));
            System.out.println(f_amount);
            if (f_amount != null) {
                chpw.setTest("good");
                String SQL_QUERY2 = "UPDATE Admin_Login set password = :password";
                Query query2 = entityManager.createQuery(SQL_QUERY2);
                query2.setParameter("password", test2);
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