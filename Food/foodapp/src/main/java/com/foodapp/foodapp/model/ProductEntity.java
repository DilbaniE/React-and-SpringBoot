package com.foodapp.foodapp.model;

import com.foodapp.foodapp.DTO.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, length = 36)
    private String uuid = UUID.randomUUID().toString();
    @Column(name = "fantasy_name")
    private String fantasyName;
    private Category category;
    private String description;
    private Double price;
    private Boolean available;
}
