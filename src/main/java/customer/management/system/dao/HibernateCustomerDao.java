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

    @Override
    public void addCustomer(Customer newCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(newCustomer);
    }
}
