package customer.management.system.dao;

import customer.management.system.entity.Customer;

import java.util.List;

public interface CustomerDaoInterface {

    public List<Customer> getCustomers();
    public void addCustomer(Customer newCustomer);
    public Customer getCustomer(int id);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(int id);


}
