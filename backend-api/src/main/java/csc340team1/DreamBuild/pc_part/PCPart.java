package csc340team1.DreamBuild.pc_part;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import csc340team1.DreamBuild.builder.Builder;
import csc340team1.DreamBuild.customer.Customer;

@Entity
@Table(name = "pc_parts")
public class PCPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String partType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int quantity;

    // COMPATIBILITY!!!!

    // CPU + Motherboard
    @Column(nullable = true)
    private String socket;

    // RAM + Motherboard
    @Column(nullable = true)
    private String ramType;

    // Motherboard + Case
    @Column(nullable = true)
    private String formFactor;

    // PSU wattage
    @Column(nullable = true)
    private Integer wattage;

    // GPU required wattage
    @Column(nullable = true)
    private Integer requiredWatt;

    // GPU length (mm)
    @Column(nullable = true)
    private Integer gpuLength;

    // Case maximum GPU length (mm)
    @Column(nullable = true)
    private Integer gpuMaxLength;

    @ManyToOne
    @JoinColumn(name = "builder_id")
    @JsonIgnore
    private Builder builder;

    @ManyToMany(mappedBy = "purchasedParts")
    @JsonIgnoreProperties("purchasedParts")
    private List<Customer> customers = new ArrayList<>();

    // Constructors
    public PCPart() {
    }

    public PCPart(String name, String description, String partType, BigDecimal price, Integer quantity, Builder builder,
            LocalDateTime createdAt, List<Customer> customers) {
        this.name = name;
        this.description = description;
        this.partType = partType;
        this.price = price;
        this.quantity = quantity;
        this.builder = builder;
        this.createdAt = LocalDateTime.now();
        this.customers = customers;
    }

    // Getters and setters
    // Part ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Part Type
    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    // Price
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Quantity
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // Time created
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Builder
    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    // Customer
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    // COMPATIBILITY GETTERS AND SETTERS

    // CPU + MOBO
    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    // RAM + MOBO
    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    // MOBO + CASE
    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    // PSU WATTAGE
    public Integer getWattage() {
        return wattage;
    }

    public void setWattage(Integer wattage) {
        this.wattage = wattage;
    }

    // GPU REQUIRED WATTAGE
    public Integer getRequiredWatt() {
        return requiredWatt;
    }

    public void setRequiredWatt(Integer requiredWatt) {
        this.requiredWatt = requiredWatt;
    }

    // GPU LENGTH (MM)
    public Integer getGpuLength() {
        return gpuLength;
    }

    public void setGpuLength(Integer gpuLength) {
        this.gpuLength = gpuLength;
    }

    // CASE MAXIMUM GPU LENGTH (MM)
    public Integer getGpuMaxLength() {
        return gpuMaxLength;
    }

    public void setGpuMaxLength(Integer gpuMaxLength) {
        this.gpuMaxLength = gpuMaxLength;
    }

}
