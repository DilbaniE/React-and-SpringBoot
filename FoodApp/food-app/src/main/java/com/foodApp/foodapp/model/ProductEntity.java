package com.foodApp.foodapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String  productName;
    @Column(name = "category")
    private String category;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "evailable")
    private Boolean available;
    @Column(unique = true, length = 36, columnDefinition = "BINARY(16)")
    private UUID uuid = UUID.randomUUID();
    private Integer stock;

}
