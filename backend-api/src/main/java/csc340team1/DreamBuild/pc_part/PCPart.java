package csc340team1.DreamBuild.pc_part;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import csc340team1.DreamBuild.builder.Builder;

@Entity
@Table(name = "pc_parts")
public class PCPart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String description;

    @Column(nullable=false)
    private LocalDateTime createdAt;

    @Column(nullable=false)
    private String partType;

    @Column(nullable=false)
    private BigDecimal price;
    
    @Column(nullable=false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "builder_id")
    @JsonIgnore
    private Builder builder;


    //Constructors
    public PCPart() {}

    public PCPart(String name, String description, String partType, BigDecimal price, Integer quantity, Builder builder) {
        this.name = name;
        this.description = description;
        this.partType = partType;
        this.price = price;
        this.quantity = quantity;
        this.builder = builder;
    }

    //Getters and setters
    //Part ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    //Name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    //Description
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    //Part Type
    public String getPartType() { return partType; }
    public void setPartType(String partType) { this.partType = partType; }

    //Price
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    //Quantity
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    //Time created
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    //Builder
    public Builder getBuilder() { return builder; }
    public void setBuilder(Builder builder) { this.builder = builder; }
}
