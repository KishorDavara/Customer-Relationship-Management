/**
 * 
 */
package com.demo.crm.dao;

import java.util.List;

import com.demo.crm.entity.Customer;

/**
 * @author kdavara
 *
 */
public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);
}
