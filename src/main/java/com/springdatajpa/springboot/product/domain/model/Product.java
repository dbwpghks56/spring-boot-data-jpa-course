package com.springdatajpa.springboot.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
    name = "tb_product",
    uniqueConstraints = { // 유니크 컬럼 설정법
        @UniqueConstraint(
            name = "sku_unique",
            columnNames = "stock_keeping_unit"
        )
    }
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Not good for JDBC batch operations
    private Long id;
    @Column(name = "stock_keeping_unit", nullable = false) // column 에 대한 세세한 설정할 때 사용
    private String sku; // Stuck keeping Unit
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
