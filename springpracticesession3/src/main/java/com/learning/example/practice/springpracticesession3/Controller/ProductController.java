package com.learning.example.practice.springpracticesession3.Controller;

import com.learning.example.practice.springpracticesession3.DTO.ProductDTO;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.ProductDetails;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.ProductUser;
import com.learning.example.practice.springpracticesession3.Repository.ProductRepository;
import com.learning.example.practice.springpracticesession3.Repository.ProductdetailsRepository;
import com.learning.example.practice.springpracticesession3.Repository.RiderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;



    @PostMapping(path = "/newProduct")
    public ResponseEntity<ProductUser> newProductCreation(@RequestBody ProductUser productUser)
    {

        //ProductDetails productDetails = productUser.getProductDetails();

        //productDetails.setProductDetailsPK(productDetails.getProductDetailsPK());

        productRepository.save(productUser);

        return ResponseEntity.ok().body(productUser);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductUser> updateProductdetails(@PathVariable Integer id ,@RequestBody ProductUser productUser)
    {
        Optional<ProductUser> byId = productRepository.findById(id);
        if (byId.isPresent())
        {
            productRepository.save(productUser);
        }
        return ResponseEntity.ok().body(productUser);
    }

    @GetMapping("/fetchProductDetails/{id}")
    public ResponseEntity<ProductUser> fetchProductdetails(@PathVariable Integer id)
    {
        ProductUser byId = productRepository.findById(id).get();

        return ResponseEntity.ok().body(byId);
    }

    //lazy fetch type configuration
//    @GetMapping("/fetchProductDetails/{id}")
//    public ResponseEntity<ProductDTO> fetchProductdetails(@PathVariable Integer id)
//    {
//        ProductUser byId = productRepository.findById(id).get();
//
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setName(byId.getName());
//        productDTO.setCost(byId.getCost());
//        productDTO.setProductMakingCost(byId.getProductDetails().getProductMakingCost());
//        productDTO.setProductLocation(byId.getProductDetails().getProductLocation());
//        productDTO.setProductContactNumber(byId.getProductDetails().getProductContactNumber());
//        //productDTO.setStreet(byId.getProductDetails().getProductDetailsPK().getStreet());
//        //productDTO.setPincode(byId.getProductDetails().getProductDetailsPK().getPincode());
//
//        return ResponseEntity.ok().body(productDTO);
//    }


}
