package csc340team1.DreamBuild.computerbuild;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import csc340team1.DreamBuild.builder.Builder;
import csc340team1.DreamBuild.pc_part.PCPart;



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
    @JsonIgnoreProperties("builds")
    private Builder builder;

    @ManyToOne @JoinColumn(name = "cpu_id") private PCPart cpu;
    @ManyToOne @JoinColumn(name = "gpu_id") private PCPart gpu;
    @ManyToOne @JoinColumn(name = "mobo_id") private PCPart mobo;
    @ManyToOne @JoinColumn(name = "case_id") private PCPart pcCase;
    @ManyToOne @JoinColumn(name = "fan_id") private PCPart fan;

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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public boolean isPrebuilt() { return isPrebuilt; }
    public void setPrebuilt(boolean isPrebuilt) { this.isPrebuilt = isPrebuilt; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Builder getBuilder() { return builder; }
    public void setBuilder(Builder builder) { this.builder = builder; }

    public PCPart getCpu() { return cpu; }
    public void setCpu(PCPart cpu) { this.cpu = cpu; }

    public PCPart getGpu() { return gpu; }
    public void setGpu(PCPart gpu) { this.gpu = gpu; }

    public PCPart getMobo() { return mobo; }
    public void setMobo(PCPart mobo) { this.mobo = mobo; }

    public PCPart getPcCase() { return pcCase; }
    public void setPcCase(PCPart pcCase) { this.pcCase = pcCase; }

    public PCPart getFan() { return fan; }
    public void setFan(PCPart fan) { this.fan = fan; }
}