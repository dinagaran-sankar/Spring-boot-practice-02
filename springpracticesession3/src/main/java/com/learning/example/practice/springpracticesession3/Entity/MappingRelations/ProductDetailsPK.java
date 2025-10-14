package com.learning.example.practice.springpracticesession3.Entity.MappingRelations;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@Setter
@Getter
public class ProductDetailsPK implements  Serializable {

    //@Column(nullable = false)
    private String street;
    //@Column(nullable = false)
    private String pincode;
}
