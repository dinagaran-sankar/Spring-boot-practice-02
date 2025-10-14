package com.learning.example.practice.springpracticesession3.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="riderDetails")
@Setter
@Getter
public class RegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "riderId",nullable = false)
    private Integer id;
    @Column(name = "riderName",nullable = false)
    private String name;
    @Column(name="riderPass",nullable = false)
    private String password;
    @Column(name = "riderContactNo",nullable = false)
    private String mobileNumber;
    @Column(name = "riderEmail",nullable = false)
    private String emailAddress;
    private String riderTravelLocation;
    private Long fees;
    @Column(name = "riderRole",nullable = false)
    private String roles;
    @JsonIgnore
    @Column(name="riderTravelDate",nullable = false)
    private Date date;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "registerEntity")
    private Set<RiderAuthority> authorities;
}
