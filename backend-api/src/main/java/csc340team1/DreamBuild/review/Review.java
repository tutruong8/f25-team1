package csc340team1.DreamBuild.review;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import csc340team1.DreamBuild.builder.Builder;
import csc340team1.DreamBuild.computerbuild.Computer;
import csc340team1.DreamBuild.customer.Customer;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "builder_id", nullable = false)
    @JsonIgnoreProperties("reviews")
    private Builder builder;

    @ManyToOne
    @JoinColumn(name = "computer_id", nullable = false)
    @JsonIgnoreProperties("reviews")
    private Computer computer;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties("reviews")
    private Customer customer;

    //Constructors
    public Review() {}

    public Review(int rating, String comment, Builder builder, Customer customer, Computer computer) {
        this.rating = rating;
        this.comment = comment;
        this.builder = builder;
        this.customer = customer;
        this.computer = computer;
    }

    //Getters and Setters
    //ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    //Rating
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    //Comment
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    //Time created
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    //Builder
    public Builder getBuilder() { return builder; }
    public void setBuilder(Builder builder) { this.builder = builder; }

    //Customer
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    //Computer
    public Computer getComputer() { return computer; }
    public void setComputer(Computer computer) { this.computer = computer;}
}