package customer.management.system.web;

import customer.management.system.dao.CustomerDaoInterface;
import customer.management.system.entity.Customer;
import customer.management.system.service.CustomerService;
import customer.management.system.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    @Qualifier(value = "CustomerService")
    CustomerServiceInterface customerService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    // @GetMapping("/list") same as the used annotation with the attribute
    public String listCustomers(Model customerModel){

        List<Customer> customers = customerService.getCustomers();
        customerModel.addAttribute("customers",customers);
        return "list-customers";
    }
    @GetMapping("addCustomerForm")
    public String showAddCustomerForm(Model newCustomerModel){

        Customer newCustomer = new Customer();
        newCustomerModel.addAttribute("newCustomer",newCustomer);
        return "add-customer-form";
    }
    @PostMapping("addCustomerForm")
    public String saveCustomer(@ModelAttribute("newCustomer")Customer customer){

        customerService.addCustomer(customer);
        return "redirect:/customers/list";
    }
}
