package com.learning.example.practice.springpracticesession3.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Rider_Authority")
@Setter
@Getter
public class RiderAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "authorityName",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "riderId")
    private RegisterEntity registerEntity;

}
