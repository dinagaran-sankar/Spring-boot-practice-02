package com.learning.example.practice.springpracticesession3.Entity.MappingRelations.onetoone;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Customer_Order")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_Id",nullable = false)
    private Integer id;

    @Column(name = "Order_Name",nullable = false)
    private String name;

    @Column(name = "Order_Cost",nullable = false)
    private Long cost;

    //@JsonIgnore
    @Column(name = "Order_CreateDate",nullable = false)
    private LocalDateTime date;

    @OneToOne(mappedBy = "orderDetails",fetch=FetchType.EAGER)
    //@JsonBackReference
    private UserEntity entity;

}
