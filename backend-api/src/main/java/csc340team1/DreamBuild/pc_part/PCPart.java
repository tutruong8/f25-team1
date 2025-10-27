package csc340team1.DreamBuild.pc_part;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import csc340team1.DreamBuild.builder.Builder;

@Entity
@Table(name = "pc_parts")
public class PCPart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @JsonIgnoreProperties("parts")
    private Builder builder;

    public PCPart() {}

    public PCPart(String description, String partType, BigDecimal price, Integer quantity, Builder builder) {
        this.description = description;
        this.partType = partType;
        this.price = price;
        this.quantity = quantity;
        this.builder = builder;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPartType() { return partType; }
    public void setPartType(String partType) { this.partType = partType; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Builder getBuilder() { return builder; }
    public void setBuilder(Builder builder) { this.builder = builder; }
}
