package com.learning.example.practice.springpracticesession3.DTO.OnetoOne;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDTO {

    @JsonProperty("User_Name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonProperty("User_ContactNo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mobileNumber;

    @JsonProperty("User_Address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userAddress;

    private OrderInfoDTO orderInfoDTO;

}
