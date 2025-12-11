package csc340team1.DreamBuild.computerbuild;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import csc340team1.DreamBuild.builder.Builder;
import csc340team1.DreamBuild.pc_part.PCPart;
import csc340team1.DreamBuild.review.Review;
import csc340team1.DreamBuild.customer.Customer;


@Entity
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=true)
    private String imageURL;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String description;

    @Column(nullable=false)
    private LocalDateTime createdAt;


    @Column(nullable=false)
    private BigDecimal price;
    
    @Column(nullable=false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "builder_id")
    @JsonIgnore
    private Builder builder;

    @ManyToOne
    @JoinColumn(name = "review_id")
    @JsonIgnore
    private Review review;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne @JoinColumn(name = "cpu_id") private PCPart cpu;
    @ManyToOne @JoinColumn(name = "gpu_id") private PCPart gpu;
    @ManyToOne @JoinColumn(name = "ram_id") private PCPart ram;
    @ManyToOne @JoinColumn(name = "storage_id") private PCPart storage;
    @ManyToOne @JoinColumn(name = "mobo_id") private PCPart mobo;
    @ManyToOne @JoinColumn(name = "case_id") private PCPart pcCase;
    @ManyToOne @JoinColumn(name = "fan_id") private PCPart fan;
    @ManyToOne @JoinColumn(name = "cooler_id") private PCPart cooler;
    @ManyToOne @JoinColumn(name = "psu_id") private PCPart psu;

    //Constructors
    public Computer() {}

    public Computer(String name, String imageURL,String description, boolean isPrebuilt, BigDecimal price, Integer quantity, Builder builder, Customer customer,
        PCPart cpu, PCPart gpu, PCPart ram, PCPart storage, PCPart mobo, PCPart pcCase, PCPart fan, PCPart cooler, PCPart psu) {
        this.name = name;
        this.imageURL = imageURL;
        this.description = description;

        this.price = price;
        this.quantity = quantity;
        this.builder = builder;
        this.customer = customer;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.mobo = mobo;
        this.pcCase = pcCase;
        this.fan = fan;
        this.cooler = cooler;
        this.psu = psu;
    }

    //Getters and Setters
    //Computer ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    //Image URL
    public String getImageURL() { return imageURL; }
    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    //Name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    //Description
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    //Time created
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    //Price
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    //Quantity
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    //Builder
    public Builder getBuilder() { return builder; }
    public void setBuilder(Builder builder) { this.builder = builder; }

    //Customer
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    //Review
    public Review getReview() { return review; }
    public void setReview(Review review) { this.review = review; }

    //PC Parts
    //CPU
    public PCPart getCpu() { return cpu; }
    public void setCpu(PCPart cpu) { this.cpu = cpu; }

    //GPU
    public PCPart getGpu() { return gpu; }
    public void setGpu(PCPart gpu) { this.gpu = gpu; }

    //RAM
    public PCPart getRam() { return ram; }
    public void setRam(PCPart ram) { this.ram = ram; }

    //Storage
    public PCPart getStorage() { return storage; }
    public void setStorage(PCPart storage) { this.storage = storage; }

    //Motherboard
    public PCPart getMobo() { return mobo; }
    public void setMobo(PCPart mobo) { this.mobo = mobo; }

    //PC Case
    public PCPart getPcCase() { return pcCase; }
    public void setPcCase(PCPart pcCase) { this.pcCase = pcCase; }

    //Fan
    public PCPart getFan() { return fan; }
    public void setFan(PCPart fan) { this.fan = fan; }

    //CPU Cooler
    public PCPart getCooler() { return cooler; }
    public void setCooler(PCPart cooler) { this.cooler = cooler; }

    //Power Supply Unit
    public PCPart getPsu() { return psu; }
    public void setPsu(PCPart psu) { this.psu = psu; }
}