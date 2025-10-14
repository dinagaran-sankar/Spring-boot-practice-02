package com.learning.example.practice.springpracticesession3.Repository;

import com.learning.example.practice.springpracticesession3.Entity.RegisterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends CrudRepository<RegisterEntity,Integer> {

    Optional<RegisterEntity> findByName(String name);
}
