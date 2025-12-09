package csc340team1.DreamBuild.customer;

import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import csc340team1.DreamBuild.review.Review;
import csc340team1.DreamBuild.computerbuild.Computer;
import csc340team1.DreamBuild.pc_part.PCPart;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String address;

    public Customer() {
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customer")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customer")
    private List<Computer> computers = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "customer_part", joinColumns = @JoinColumn(name = "customer = id"), inverseJoinColumns = @JoinColumn(name = "pcpart_id"))
    @JsonIgnoreProperties("customers")
    private List<PCPart> purchasedParts = new ArrayList<>();

    public Customer(long customerId, String name, String email, String password, String address) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public Customer(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    // getters and setter

    // Customer ID
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    public List<PCPart> getPurchasedParts() {
        return purchasedParts;
    }

    public void setPurchasedParts(List<PCPart> purchasedParts) {
        this.purchasedParts = purchasedParts;
    }
}
