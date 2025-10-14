package com.learning.example.practice.springpracticesession3.Entity.MappingRelations;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="productsInfo")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productInfoId")
    private Integer productInfoId;

    //@EmbeddedId
    //private ProductDetailsPK productDetailsPK;

    private String productMakingCost;

    private String productLocation;

    private String productContactNumber;

    //one to one bidirectional
    @OneToOne(mappedBy = "productDetails")
    private ProductUser productUser;
}
