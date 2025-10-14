package com.learning.example.practice.springpracticesession3.DTO.OnetoMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class VehicleDTO {

    @JsonProperty("vehicleName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonProperty("numberOfVehicle")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer noOfVehicle;

    @JsonProperty("vehicleNumber")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long vehicleNumber;

    @JsonFormat(pattern = "DD/MM/YYYY HH24:MM:SS")
    private LocalDateTime dateTime;
}
