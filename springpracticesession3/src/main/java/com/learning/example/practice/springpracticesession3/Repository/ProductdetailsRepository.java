package com.learning.example.practice.springpracticesession3.Repository;

import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductdetailsRepository extends JpaRepository<ProductDetails,Integer> {

}
