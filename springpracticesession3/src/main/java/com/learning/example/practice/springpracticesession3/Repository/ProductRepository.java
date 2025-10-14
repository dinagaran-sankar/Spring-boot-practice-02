package com.learning.example.practice.springpracticesession3.Repository;

import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.ProductUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductUser,Integer> {
}
