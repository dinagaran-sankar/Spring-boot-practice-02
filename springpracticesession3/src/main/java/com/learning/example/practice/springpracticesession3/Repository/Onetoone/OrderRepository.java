package com.learning.example.practice.springpracticesession3.Repository.Onetoone;

import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.onetoone.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<UserEntity,Integer> {
}
