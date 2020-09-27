package customer.management.system.service;

import customer.management.system.entity.Customer;

import java.util.List;

public interface CustomerServiceInterface {

    public List<Customer> getCustomers();
    public void addCustomer(Customer customer);
    public Customer getCustomer(int id);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(int id);
}
