package com.foodApp.foodapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "delivery")
public class DeliveryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "extra_information")
    private String extraInformation;
    @Column(name = "creation_datatime")
    private LocalDateTime cretionDateTime;
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

    @Column(unique = true)
    private UUID uuid;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity clientModel;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity productModel;

    public DeliveryEntity(Boolean isDelivered){
        this.isDelivered = false;
    }
}
