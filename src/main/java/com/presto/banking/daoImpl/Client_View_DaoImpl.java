package com.presto.banking.daoImpl;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.presto.banking.actionForm.Client_View;
import com.presto.banking.util.HibernateUtil;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.apache.struts2.interceptor.SessionAware;


/**
 *
 *
 * @author VS60001724
 */
public class Client_View_DaoImpl extends HibernateUtil implements ModelDriven<Object> , SessionAware {
    private Map<String, Object> usersession;

    EntityManagerFactory entityManagerFactory = HibernateUtil.getSessionFactory();

    EntityManager entityManager;

    /**
     *
     *
     * @param view
     * 		Client View Transactions
     * @return 
     */
    @SuppressWarnings("unchecked")
    public List<Client_View> list(Client_View view) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        usersession = ActionContext.getContext().getSession();
        String abcd = ((String) (usersession.get("user1")));
        System.out.println(("From DAOIMPL Class:" + abcd));
        List<Client_View> details = null;
        try {
            entityManager.createQuery((("From Client_View WHERE clid=" + abcd) + ""));
            System.out.println(details);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
        return details;
    }

    /**
     *
     *
     * @param abc
     * 		Client View Current Balance
     * @return 
     */
    public Client_View vish(Client_View abc) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        usersession = ActionContext.getContext().getSession();
        String abcd = ((String) (usersession.get("user1")));
        System.out.println(("From DAOIMPL Class:" + abcd));
        try {
            String SQL_QUERY = ("SELECT view.amount FROM Client_View view WHERE view.clid ='" + abcd) + "' ORDER BY view.id DESC LIMIT 1";
            Query query = entityManager.createQuery(SQL_QUERY);
            @SuppressWarnings("rawtypes")
            List results = query.getResultList();
            String f_amount = ((String) (results.get(0)));
            System.out.println(results);
            System.out.println(f_amount);
            abc.setNamount(f_amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        entityManager.getTransaction().commit();
        return abc;
    }

    public void setUsersession(Map<String, Object> usersession) {
        this.usersession = usersession;
    }

    public Object getModel() {
        return null;
    }

    public void setSession(Map<String, Object> arg0) {
    }
}

