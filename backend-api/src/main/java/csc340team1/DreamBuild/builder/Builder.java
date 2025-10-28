package csc340team1.DreamBuild.builder;

import java.util.*;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import csc340team1.DreamBuild.pc_part.PCPart;
import csc340team1.DreamBuild.computerbuild.Computer;
import csc340team1.DreamBuild.review.Review;

@Entity
@Table(name = "builders")
public class Builder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;
    
    @Column(nullable=false)
    private String address;

    @OneToMany(mappedBy = "builder", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("builder")
    private List<PCPart> parts = new ArrayList<>(); 

    @OneToMany(mappedBy = "builder", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("builder")
    private List<Computer> builds = new ArrayList<>();

    @OneToMany(mappedBy = "builder", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("builder")
    private List<Review> reviews = new ArrayList<>();


    //Constructors
    public Builder(){}

    public Builder(Long id, String name, String email, String password, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public Builder(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    //Getters and setters
    //Builder ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    //Name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    //Email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    //Password
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    //Address
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    //PC Parts
    public List<PCPart> getParts() { return parts; }
    public void setParts(List<PCPart> parts) { this.parts = parts; }

    //Computer Builds
    public List<Computer> getBuilds() { return builds; }
    public void setBuilds(List<Computer> builds) { this.builds = builds; }

}
