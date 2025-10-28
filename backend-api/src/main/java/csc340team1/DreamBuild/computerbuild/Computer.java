package csc340team1.DreamBuild.computerbuild;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import csc340team1.DreamBuild.builder.Builder;
import csc340team1.DreamBuild.pc_part.PCPart;
import csc340team1.DreamBuild.review.Review;



@Entity
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String description;

    @Column(nullable=false)
    private LocalDateTime createdAt;

    @Column(nullable=false)
    private boolean isPrebuilt;

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

    @ManyToOne @JoinColumn(name = "cpu_id") private PCPart cpu;
    @ManyToOne @JoinColumn(name = "gpu_id") private PCPart gpu;
    @ManyToOne @JoinColumn(name = "mobo_id") private PCPart mobo;
    @ManyToOne @JoinColumn(name = "case_id") private PCPart pcCase;
    @ManyToOne @JoinColumn(name = "fan_id") private PCPart fan;

    //Constructors
    public Computer() {}

    public Computer(String description, boolean isPrebuilt, BigDecimal price, Integer quantity, Builder builder, PCPart cpu, PCPart gpu, PCPart mobo, PCPart pcCase, PCPart fan) {
        this.description = description;
        this.isPrebuilt = isPrebuilt;
        this.price = price;
        this.quantity = quantity;
        this.builder = builder;
        this.cpu = cpu;
        this.gpu = gpu;
        this.mobo = mobo;
        this.pcCase = pcCase;
        this.fan = fan;
    }


    //Getters and Setters
    //Computer ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    //Description
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    //Time created
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    //If it is a prebuilt or not
    public boolean isPrebuilt() { return isPrebuilt; }
    public void setPrebuilt(boolean isPrebuilt) { this.isPrebuilt = isPrebuilt; }

    //Price
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    //Quantity
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    //Builder
    public Builder getBuilder() { return builder; }
    public void setBuilder(Builder builder) { this.builder = builder; }

    //PC Parts
    //CPU
    public PCPart getCpu() { return cpu; }
    public void setCpu(PCPart cpu) { this.cpu = cpu; }

    //GPU
    public PCPart getGpu() { return gpu; }
    public void setGpu(PCPart gpu) { this.gpu = gpu; }

    //Motherboard
    public PCPart getMobo() { return mobo; }
    public void setMobo(PCPart mobo) { this.mobo = mobo; }

    //PC Case
    public PCPart getPcCase() { return pcCase; }
    public void setPcCase(PCPart pcCase) { this.pcCase = pcCase; }

    //Fan
    public PCPart getFan() { return fan; }
    public void setFan(PCPart fan) { this.fan = fan; }
}