package csc340team1.DreamBuild.customer;

import java.util.*;
import java.io.IOException;
import java.io.File;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

     /**
   * Method to get all customers in the database
   * @return list of customers in database
   */
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

 
     /**
   * Method to get customer by ID in the database
   * @param id ID of the customer to get
   * @return customer with the specified ID
   */
    public Object getCustomerById(long id) {
        return customerRepo.findById(id).orElse(null);
    }

    /**
   * Method to get customer by email in the database
   * @param email email of the customer to get
   * @return customer with the specified email
   */
    public Object getCustomerByEmail(String email) {
        return customerRepo.findByEmail(email);
    }

   /**
   * Method to create new customer in the database
   * @param customer Customer to create
   * @return created customer
   */
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    /**
   * Method to update customer in the database
   * @param id ID of the customer to update
   * @param updatedCustomer updated customer information
   * @return updated customer
   */
    
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

     /**
     * Method to authenticate a customer
     * */
    public Customer authenticate(String email, String password) {
        Customer customer = customerRepo.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Customer not found! Try again."));
        if (!customer.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid email or password! Try again.");
        }
        return customer;
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