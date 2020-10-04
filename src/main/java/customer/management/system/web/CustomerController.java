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
import java.util.logging.Logger;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    //private Logger logger = Logger.getLogger(getClass().getName());


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
    @RequestMapping(value = "/update",params = "customerid",method = RequestMethod.GET)
    public String updateCustomer(@RequestParam(name = "customerid") int id,Model customerModel)
    {
        Customer newCustomer = customerService.getCustomer(id);
        //System.out.println("before binding" + newCustomer);
        customerModel.addAttribute("customer",newCustomer);
        return "update-customer-form";
    }
    @RequestMapping(value = "/updateCustomerForm",method = RequestMethod.POST)
    public String saveUpdatedCustomer(@ModelAttribute("customer") Customer customer)
    {
        //System.out.println("after modifications: "+customer);
        customerService.updateCustomer(customer);
        return "redirect:/customers/list";
    }

    @RequestMapping(value = "/delete",params = "customerid")
    public String deleteCustomer(@RequestParam(name = "customerid") int id)
    {
        customerService.deleteCustomer(id);
        return "redirect:/customers/list";
    }
}
