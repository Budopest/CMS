package customer.management.system.web;

import customer.management.system.dao.CustomerDaoInterface;
import customer.management.system.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    @Qualifier(value = "HibernateCustomerDao")
    CustomerDaoInterface customerDao;

    @RequestMapping("/list")
    public String listCustomers(Model customerModel){

        List<Customer> customers = customerDao.getCustomers();
        customerModel.addAttribute("customers",customers);
        
        return "list-customers";
    }
}
