package customer.management.system.service;

import customer.management.system.dao.CustomerDaoInterface;
import customer.management.system.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "CustomerService")
public class CustomerService implements CustomerServiceInterface  {

    @Autowired
    @Qualifier(value = "HibernateCustomerDao")
    CustomerDaoInterface customerDao;


    @Override
    @Transactional //define beginning and end of transactional implicitly
    public List<Customer> getCustomers() {
        return  customerDao.getCustomers();
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }
}
