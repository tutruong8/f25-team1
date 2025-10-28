package csc340team1.DreamBuild.review;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import csc340team1.DreamBuild.customer.Customer;
//import csc340team1.DreamBuild.computerBuild.Computer;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({ "reviews" })
    private Customer customer;

    // unresolved for rn

    // @ManyToOne
    // @JoinColumn(name = "computer", nullable = false)
    // @JsonIgnoreProperties("reviews")
    // private Computer computer;

    @DecimalMin("1.0")
    @DecimalMax("5.0")
    private Double overallRating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String builderResponse;

    private LocalDateTime builderResponseDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Double overallRating) {
        this.overallRating = overallRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getBuilderResponse() {
        return builderResponse;
    }

    public void setBuilderResponse(String builderResponse) {
        this.builderResponse = builderResponse;
    }

    public LocalDateTime getBuilderResponseDate() {
        return builderResponseDate;
    }

    public void setBuilderResponseDate(LocalDateTime builderResponseDate) {
        this.builderResponseDate = builderResponseDate;
    }

}