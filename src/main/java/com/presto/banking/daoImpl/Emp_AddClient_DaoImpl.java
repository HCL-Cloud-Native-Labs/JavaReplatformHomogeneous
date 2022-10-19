package com.presto.banking.daoImpl;
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
import com.presto.banking.actionForm.Emp_AddClient;
import com.presto.banking.util.HibernateUtil;
/**
 *
 *
 * @author VS60001724
 */
public class Emp_AddClient_DaoImpl extends HibernateUtil implements ModelDriven<Object> , SessionAware {
    private Map<String, Object> usersession;
    
    EntityManagerFactory entityManagerFactory = HibernateUtil.getSessionFactory();
	EntityManager entityManager;
	
    /**
     *
     *
     * @param addClient
     * 		Employee Add client
     * @return 
     */
    public Emp_AddClient addClient(Emp_AddClient addClient) {
    	entityManager = entityManagerFactory.createEntityManager();
         entityManager.getTransaction().begin();
        try {
            entityManager.persist(addClient);
        } catch (HibernateException e) {
            System.out.println(e);
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
        return addClient;
    }

    /**
     *
     *
     * @param addClients
     * 		Add Clients
     * @return 
     */
    public Client_Login addClients(Client_Login addClients) {
    	entityManager = entityManagerFactory.createEntityManager();
         entityManager.getTransaction().begin();
        Client_Login abcd = new Client_Login();
        String bank_id = addClients.getBank_id();
        abcd.setBank_id(bank_id);
        String uname = addClients.getUserName();
        abcd.setUserName(uname);
        String pw = addClients.getPassword();
        String mpw = md5(pw);
        abcd.setPassword(mpw);
        try {
            entityManager.persist(abcd);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
        return addClients;
    }

    @SuppressWarnings("unchecked")
    public List<Emp_AddClient> list(Emp_AddClient edit) {
        usersession = ActionContext.getContext().getSession();
        entityManager = entityManagerFactory.createEntityManager();
         entityManager.getTransaction().begin();
        String clid = edit.getBank_id();
        System.out.println(clid);
        List<Emp_AddClient> details = null;
        try {
            entityManager.createQuery(("From Emp_AddClient WHERE bank_id=" + clid) + "");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
        usersession.put("test", clid);
        entityManager.getTransaction().commit();
        return details;
    }

    public Emp_AddClient eclient(Emp_AddClient eclient) {
        usersession = ActionContext.getContext().getSession();
        entityManager = entityManagerFactory.createEntityManager();
         entityManager.getTransaction().begin();
        String branch = eclient.getBranch();
        String firstName = eclient.getFirstName();
        String middleName = eclient.getMiddleName();
        String lastName = eclient.getLastName();
        String gender = eclient.getGender();
        String dob = eclient.getDob();
        String landLine = eclient.getLandLine();
        String mobile = eclient.getMobile();
        String email = eclient.getEmail();
        String address = eclient.getAddress();
        String city = eclient.getCity();
        String state = eclient.getState();
        String abcd = ((String) (usersession.get("test")));
        try {
            String SQL_QUERY2 = "UPDATE Emp_AddClient eclient set " + (((((((((((("eclient.branch = :branch, " + "eclient.firstName = :firstName, ") + "eclient.middleName = :middleName, ") + "eclient.lastName = :lastName, ") + "eclient.gender = :gender, ") + "eclient.dob = :dob, ") + "eclient.landLine = :landLine, ") + "eclient.mobile = :mobile, ") + "eclient.email = :email, ") + "eclient.address = :address, ") + "eclient.city = :city, ") + "eclient.state = :state ") + "WHERE eclient.bank_id = :abcd");
            Query query2 = entityManager.createQuery(SQL_QUERY2);
            query2.setParameter("branch", branch);
            query2.setParameter("firstName", firstName);
            query2.setParameter("middleName", middleName);
            query2.setParameter("lastName", lastName);
            query2.setParameter("gender", gender);
            query2.setParameter("dob", dob);
            query2.setParameter("landLine", landLine);
            query2.setParameter("mobile", mobile);
            query2.setParameter("email", email);
            query2.setParameter("address", address);
            query2.setParameter("city", city);
            query2.setParameter("state", state);
            query2.setParameter("abcd", abcd);
            int result = query2.executeUpdate();
            System.out.println("Rows affected: " + result);
        } catch (HibernateException e) {
            System.out.println(e);
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
        usersession.remove("test");
        return eclient;
    }

    public void setSession(Map<String, Object> arg0) {
    }

    public Object getModel() {
        return null;
    }
}