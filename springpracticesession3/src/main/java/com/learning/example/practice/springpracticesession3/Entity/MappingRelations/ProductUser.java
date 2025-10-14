package com.learning.example.practice.springpracticesession3.Entity.MappingRelations;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name="products")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productUserId")
    private Integer id;

    @Column(name = "productName",nullable = false)
    private String name;

    @Column(name = "productCost",nullable = false)
    private Long cost;

    //@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "productInfoId", referencedColumnName = "productInfoId")
           // @JoinColumn(name = "productInfoStreet", referencedColumnName = "street"),
           // @JoinColumn(name = "productInfoPincode", referencedColumnName = "pincode")
    })
    @JsonManagedReference
    private ProductDetails productDetails;
}
