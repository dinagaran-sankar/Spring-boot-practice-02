package com.learning.example.practice.springpracticesession3.DTO.OnetoOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderInfoDTO {

    @JsonProperty("Order_Name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonProperty("Order_Cost")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long cost;

    @JsonProperty(value = "Order_CreateDate",access = JsonProperty.Access.READ_ONLY)
    //@JsonIgnore
    private LocalDateTime date;

}
