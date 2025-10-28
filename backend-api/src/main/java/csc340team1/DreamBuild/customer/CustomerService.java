package csc340team1.DreamBuild.customer;

import java.util.*;
import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

 
    public Object getCustomerById(@PathVariable long id) {
        return customerRepo.findById(id);
    }

   
    public Object getCustomerByEmail(@PathVariable String email) {
        return customerRepo.findByEmail(email);
    }

   
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepo.findById(id).map(customer -> {
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPassword(updatedCustomer.getPassword());
            customer.setAddress(updatedCustomer.getAddress());
            return customerRepo.save(customer);
        }).orElseGet(() -> {
            updatedCustomer.setCustomerId(id);
            return customerRepo.save(updatedCustomer);
        });
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }
    
    
    public String writeJson(Customer customer) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("customer.json"), customer);
        return "Customer has been written to JSON file";
    }

    
    public Customer readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("customer.json"), Customer.class);
    }
}