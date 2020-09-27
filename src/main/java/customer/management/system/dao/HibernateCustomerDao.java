package customer.management.system.dao;

import customer.management.system.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "HibernateCustomerDao")
public class HibernateCustomerDao implements CustomerDaoInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    //@Transactional moved to the service layer methods
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> query = currentSession.createQuery("from Customer",Customer.class);
        return query.getResultList();
    }
    public Customer getCustomer(int id){
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class,id);
    }

    @Override
    public void addCustomer(Customer newCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(newCustomer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer retrievedCustomer = getCustomer(customer.getId());
        retrievedCustomer.update(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = currentSession.get(Customer.class,id);
        currentSession.remove(customer);

    }
}
