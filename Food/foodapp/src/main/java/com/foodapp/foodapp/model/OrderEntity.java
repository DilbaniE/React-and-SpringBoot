package com.foodapp.foodapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private UUID uuid;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;
    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "extra_information")
    private String extraInformation;
    @Column(name = "creation_datetime")
    private LocalDateTime creationDateTime;
    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;
    @Column(name = "tax")
    private Double tax;
    @Column(name = "grand_total")
    private Double grandTotal;
    @Column(name = "sub_total")
    private Double subTotal;
    @Column(name = "delivered")
    private Boolean isDelivered = false;
    public OrderEntity(Boolean isDelivered) {
        this.isDelivered = false;
    }
}
