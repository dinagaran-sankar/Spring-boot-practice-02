package com.learning.example.practice.springpracticesession3.Entity.MappingRelations.onetomany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "person")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personId",nullable = false)
    private Integer id;

    @Column(name = "personName",nullable = false)
    private String name;

    @Column(name = "personAddress",nullable = false)
    private String address;

    @Column(name = "personContactNo",nullable = false)
    private String mobileNumber;

    @Column(name = "personEmailId",nullable = false)
    private String emailAddress;

    @OneToMany(mappedBy = "personEntities", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<VehicleEntity> vehicleEntities;
}
