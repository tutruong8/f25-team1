package csc340team1.DreamBuild.computerbuild;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import csc340team1.DreamBuild.pc_part.PCPart;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    private PCPart cpu;
    private PCPart gpu;
    private PCPart ram;
    private PCPart storage;
    private PCPart motherboard;


}
