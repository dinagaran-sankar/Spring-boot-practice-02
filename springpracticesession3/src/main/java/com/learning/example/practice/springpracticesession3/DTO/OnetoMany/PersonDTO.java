package com.learning.example.practice.springpracticesession3.DTO.OnetoMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.onetomany.VehicleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonDTO {

    @JsonProperty("personName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonProperty("personAddress")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String address;

    @JsonProperty("personContactNo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mobileNumber;

    @JsonProperty("personEmailId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String emailAddress;

    private List<VehicleDTO> vehicleDTO;
}
