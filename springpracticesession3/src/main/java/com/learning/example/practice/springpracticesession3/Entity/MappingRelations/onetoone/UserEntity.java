package com.learning.example.practice.springpracticesession3.Entity.MappingRelations.onetoone;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User_Order")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id",nullable = false)
    private Integer id;

    @Column(name = "User_Name",nullable = false)
    private String name;


    @Column(name = "User_ContactNo",nullable = false)
    private String mobileNumber;


    @Column(name = "User_Address",nullable = false)
    private String userAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId",referencedColumnName = "Order_Id")
    private OrderDetailsEntity orderDetails;


}
