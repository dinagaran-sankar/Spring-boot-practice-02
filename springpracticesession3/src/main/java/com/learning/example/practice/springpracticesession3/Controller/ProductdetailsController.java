package com.learning.example.practice.springpracticesession3.Controller;

import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.ProductDetails;
import com.learning.example.practice.springpracticesession3.Repository.ProductdetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
@RequiredArgsConstructor
public class ProductdetailsController {

    private final ProductdetailsRepository productdetailsRepository;

    @GetMapping("/fetchProductInfoDetails/{id}")
    public ResponseEntity<ProductDetails> fetchProductInfodetails(@PathVariable Integer id)
    {
        ProductDetails byId = productdetailsRepository.findById(id).get();

        return ResponseEntity.ok().body(byId);
    }
}
