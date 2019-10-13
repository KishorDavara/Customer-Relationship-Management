/**
 * 
 */
package com.demo.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.demo.crm.entity.Customer;

/**
 * @author kdavara
 *
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		//save/update the customer
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, customerId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id=:theCustomerId");
		
		query.setParameter("theCustomerId", customerId);
		
		query.executeUpdate();
	}
	
	@Override
    public List<Customer> searchCustomers(String theSearchName) {
        Session session = sessionFactory.getCurrentSession();
        
        Query<Customer> query = null;
        
        // only search by name if theSearchName is not empty
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            query = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            query.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            query = session.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = query.getResultList();
                
        // return the results        
        return customers;
        
    }

}
