package csc340team1.DreamBuild.customer;

import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Object getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customer/email")
    public Object getCustomerByEmail(@RequestParam String email) {
        return customerService.getCustomerByEmail(email);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public Object deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return customerService.getAllCustomers();
    }

    @PostMapping("/customer/write")
    public Object writeJson(@RequestBody Customer customer) throws IOException {
        return customerService.writeJson(customer);
    }

    @PostMapping("/customer/read")
    public Object readJson() throws IOException {
        return customerService.readJson();
    }
}
