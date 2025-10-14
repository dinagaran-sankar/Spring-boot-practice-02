package com.learning.example.practice.springpracticesession3.Controller;

import com.learning.example.practice.springpracticesession3.DTO.OnetoMany.PersonDTO;
import com.learning.example.practice.springpracticesession3.DTO.OnetoMany.VehicleDTO;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.onetomany.PersonEntity;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.onetomany.VehicleEntity;
import com.learning.example.practice.springpracticesession3.Repository.onetomany.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/person")
@RequiredArgsConstructor
public class PersonVehicleController {

    private final PersonRepository repository;

    @PostMapping(path = "/createPersonVehicle")
    public ResponseEntity<PersonDTO> createNewPerson(@RequestBody PersonDTO personDTO)
    {
        List<VehicleEntity> collect = personDTO.getVehicleDTO()
                .stream().map(vehicleDTO -> {
                    VehicleEntity vehicleEntity = new VehicleEntity();
                    vehicleEntity.setName(vehicleDTO.getName());
                    vehicleEntity.setNoOfVehicle(vehicleDTO.getNoOfVehicle());
                    vehicleEntity.setVehicleNumber(vehicleDTO.getVehicleNumber());
                    vehicleEntity.setDateTime(LocalDateTime.now());
                    return vehicleEntity;
                }).collect(Collectors.toList());

        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personDTO.getName());
        personEntity.setAddress(personDTO.getAddress());
        personEntity.setMobileNumber(personDTO.getMobileNumber());
        personEntity.setEmailAddress(personDTO.getEmailAddress());

        List<VehicleEntity> collect1 = collect.stream().map(vehicleEntity -> {
            vehicleEntity.setPersonEntities(personEntity);
            return vehicleEntity;
        }).collect(Collectors.toList());

        personEntity.setVehicleEntities(collect1);

        PersonEntity save = repository.save(personEntity);
        List<VehicleEntity> vehicleEntities = save.getVehicleEntities();
        List<VehicleDTO> listVehicleDTO = vehicleEntities.stream().map(vehicleEntity -> {
            VehicleDTO vehicleDTO = new VehicleDTO(vehicleEntity.getName(),
                    vehicleEntity.getNoOfVehicle(), vehicleEntity.getVehicleNumber(),
                    vehicleEntity.getDateTime());
            return vehicleDTO;
        }).collect(Collectors.toList());



        PersonDTO personUser = new PersonDTO(save.getName(),save.getAddress(),save.getMobileNumber(),save.getEmailAddress(), listVehicleDTO);

        return ResponseEntity.ok().body(personUser);
    }

    @GetMapping(path = "/fetchVehicleDetails/{id}")
    public ResponseEntity<PersonDTO> fetchVehicleDetails(@PathVariable Integer id)
    {
        PersonEntity personEntity = repository.findById(id).get();

        List<VehicleEntity> vehicleEntities = personEntity.getVehicleEntities();

        List<VehicleDTO> collect = vehicleEntities.stream().map(vehicle -> {
            VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getName(), vehicle.getNoOfVehicle(),
                    vehicle.getVehicleNumber(), vehicle.getDateTime());
            return vehicleDTO;
        }).collect(Collectors.toList());

        PersonDTO personDTO = new PersonDTO(personEntity.getName(),personEntity.getAddress(),
                personEntity.getMobileNumber(), personEntity.getEmailAddress(),collect);

        System.out.println("response: " + personDTO);

        return  ResponseEntity.ok().body(personDTO);
    }

}
