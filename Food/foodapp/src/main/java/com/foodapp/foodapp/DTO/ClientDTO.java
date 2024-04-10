package com.foodapp.foodapp.DTO;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    //Datos que se le mandaran al usuario solo lo que nesesita el usuario
    private String document;
    private String name;
    private String email;
    private String phone;
    private String deliverAddress;
    private Boolean isActive = true;
}
