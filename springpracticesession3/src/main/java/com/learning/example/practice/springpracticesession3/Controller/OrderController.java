package com.learning.example.practice.springpracticesession3.Controller;

import com.learning.example.practice.springpracticesession3.DTO.OnetoOne.OrderInfoDTO;
import com.learning.example.practice.springpracticesession3.DTO.OnetoOne.UserInfoDTO;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.onetoone.OrderDetailsEntity;
import com.learning.example.practice.springpracticesession3.Entity.MappingRelations.onetoone.UserEntity;
import com.learning.example.practice.springpracticesession3.Repository.Onetoone.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/order")
@RequiredArgsConstructor
public class OrderController {

        private final OrderRepository orderRepository;

        @PostMapping(path = "/create-Order")
        public ResponseEntity<UserInfoDTO> createNewOrder(@RequestBody UserInfoDTO userInfoDTO) {
                System.out.println("ordr entity: " + userInfoDTO.getOrderInfoDTO().getName());

                OrderDetailsEntity orderDetails = new OrderDetailsEntity();
                orderDetails.setName(userInfoDTO.getOrderInfoDTO().getName());
                orderDetails.setCost(userInfoDTO.getOrderInfoDTO().getCost());
                orderDetails.setDate(LocalDateTime.now());

                // user entity
                UserEntity userInfo = new UserEntity();
                userInfo.setName(userInfoDTO.getName());
                userInfo.setMobileNumber(userInfoDTO.getMobileNumber());
                userInfo.setUserAddress(userInfoDTO.getUserAddress());
                userInfo.setOrderDetails(orderDetails);

                UserEntity save = orderRepository.save(userInfo);
                OrderInfoDTO orderInfoDTO = new OrderInfoDTO(
                                save.getOrderDetails().getName(), save.getOrderDetails().getCost(),
                                save.getOrderDetails().getDate());
                UserInfoDTO userDTO = new UserInfoDTO(
                                save.getName(), save.getMobileNumber(), save.getUserAddress(), orderInfoDTO);
                return ResponseEntity.ok().body(userDTO);
        }

        @GetMapping(path = "/fetchOrderDetails/{id}")
        public ResponseEntity<UserInfoDTO> fetchOrderDetails(@PathVariable Integer id) {
                UserEntity userEntity = orderRepository.findById(id).get();

                OrderDetailsEntity orderDetails = userEntity.getOrderDetails();
                OrderInfoDTO orderInfoDTO = new OrderInfoDTO(orderDetails.getName(),
                                orderDetails.getCost(), orderDetails.getDate());
                UserInfoDTO userInfoDTO = new UserInfoDTO(userEntity.getName(), userEntity.getMobileNumber(),
                                userEntity.getUserAddress(), orderInfoDTO);
                return ResponseEntity.ok()
                                .body(userInfoDTO);
        }

        // bidirectional
        @GetMapping("/fetchUserDetails/{id}")
        public ResponseEntity<OrderInfoDTO> fetchUserDetails(@PathVariable Integer id) {
                UserEntity userEntity = orderRepository.findById(id).get();

                OrderDetailsEntity orderDetails = userEntity.getOrderDetails();
                OrderInfoDTO orderInfoDTO = new OrderInfoDTO(orderDetails.getName(),
                                orderDetails.getCost(), orderDetails.getDate());
                // UserInfoDTO userInfoDTO = new UserInfoDTO(userEntity.getName(),
                // userEntity.getMobileNumber(),userEntity.getUserAddress(),orderInfoDTO);
                return ResponseEntity.ok()
                                .body(orderInfoDTO);
        }
}
