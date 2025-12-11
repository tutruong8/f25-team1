package csc340team1.DreamBuild.customer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

   /**
   * Endpoint to get all builders in the database
   *
   * @return List of all builders in the databasegi
   */

    @GetMapping("/customer")

    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("title", "Customers");
        return "customer-list";
    }

    

    @GetMapping("/customer/{id}/landing")
public String customerLanding(@PathVariable Long id, Model model) {
    model.addAttribute("customer", customerService.getCustomerById(id));
    return "Customer/customerLanding";
}

   /**
   * Endpoint to get the desired customer through ID. You can view and update customer info on the same page
   * @param id ID of the customer to get
   * @param model Model to add attributes to
   * @return Customer profile page
   */

    @GetMapping("/customer/{id}")
    public Object getCustomerById(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        model.addAttribute("title", "Customer Details");
        return "customer/customerProfile";
    }

    


 /**
   * Endpoint to get to see reviews of a customer through ID
   * @param id ID of the customer to get
   * @param model Model to add attributes to
   * @return Customer review page
   */

  @GetMapping("/customer/{id}/reviews")
    public Object getBuilderReviews(@PathVariable long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        model.addAttribute("title", "Customer Reviews");
        return "customer/customerReviews";
    }

   /**
   * Endpoint to see signup page for a new customer
   * @param model Model to add attributes to
   * @return Customer signup page
   */

   @GetMapping("/customer/new")
   public Object customerSignUp(Model model){
    Customer newCustomer = new Customer();
    model.addAttribute("customer", newCustomer);
    model.addAttribute("title", "Sign Up Customer");
    return "CustomerSignUp";
   }

     /**
   * Endpoint to see signup page for a new customer
   * @param model Model to add attributes to
   * @return Customer signup page
   */
  @GetMapping("/customer/existing")
  public Object customerLogin(Model model) {
    model.addAttribute("title", "Log in Customer");
    return "CustomerLogin";
  }
  

    @PostMapping("/customer")
    public Object createCustomer(Customer customer) {
        Customer newCustomer = customerService.createCustomer(customer);
        return "redirect:/customer/" + newCustomer.getCustomerId() + "/landing";
    }

    @PostMapping("/customer/signin")
public String signIn(@RequestParam String email, @RequestParam String password, HttpSession session) {
    try {
        Customer customer = customerService.authenticate(email, password);
        session.setAttribute("customerId", customer.getCustomerId());
        return "redirect:/customer/" + customer.getCustomerId() + "/landing";
    } catch (Exception e) {
        return "redirect:/customer/existing?error";
    }
}

    
    /**
   * Endpoint to update a customer in the database
   * @param id ID of the customer to update
   * @param updatedCustomer Customer with updated information
   * @return updated customer
   */
    @PostMapping("/customer/{id}")
    public Object updateCustomer(@PathVariable Long id, Customer customer) {
        customerService.updateCustomer(id, customer);
        return "redirect:/customer/" + id;
    }

    /**
   * Endpoint to delete a customer in the database
   * @param id ID of the customer to delete
   * @return list of customer in database after deletion
   */

    @PostMapping("/customer/delete/{id}")
    public Object deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer";
    }

    /**
   * Endpoint to write customer in JSON file
   * @param builder Customer to write
   * @return success message (empty string if successful)
   */
    @PostMapping("/customer/write")
    public Object writeJson(@RequestBody Customer customer) throws IOException {
        return customerService.writeJson(customer);
    }

    /**
   * Endpoint read Builder JSON file contents
   * @return contents in JSON
   */
    @PostMapping("/customer/read")
    public Object readJson() throws IOException {
        return customerService.readJson();
    }
}
