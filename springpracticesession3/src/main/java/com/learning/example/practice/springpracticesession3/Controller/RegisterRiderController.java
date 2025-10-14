package com.learning.example.practice.springpracticesession3.Controller;

import com.learning.example.practice.springpracticesession3.Entity.RegisterEntity;
import com.learning.example.practice.springpracticesession3.Entity.RiderAuthority;
import com.learning.example.practice.springpracticesession3.Repository.RiderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.sql.Date;

@RestController
@RequestMapping(path = "/RegisterRider",produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class RegisterRiderController {

    private final RiderRepository riderRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(path = "/createRiderName",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerRiderDetails(@RequestBody RegisterEntity registerEntity)
    {
         registerEntity.setPassword(passwordEncoder.encode(registerEntity.getPassword()));
         registerEntity.setDate(new Date(System.currentTimeMillis()));

//         for (RiderAuthority riderAuthority : registerEntity.getAuthorities())
//         {
//             riderAuthority.setRegisterEntity(registerEntity);
//         }
         riderRepository.save(registerEntity);

         return ResponseEntity.status(HttpStatus.OK)
                 .body("Rider Details Succeffuly created");
    }
}
