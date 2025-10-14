package com.learning.example.practice.springpracticesession3.DTO;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private Long cost;
    private String productMakingCost;
    private String productLocation;
    private String productContactNumber;
    private String street;
    private String pincode;
}
