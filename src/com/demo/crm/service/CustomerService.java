/**
 * 
 */
package com.demo.crm.service;

import java.util.List;

import com.demo.crm.entity.Customer;

/**
 * @author kdavara
 *
 */
public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);
	
    public List<Customer> searchCustomers(String theSearchName);
}
