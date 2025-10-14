//package com.learning.example.practice.springpracticesession3.securityConfig;
//
//import com.learning.example.practice.springpracticesession3.Entity.RegisterEntity;
//import com.learning.example.practice.springpracticesession3.Repository.RiderRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailService implements UserDetailsService {
//
//    private final RiderRepository riderRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        System.out.println("username"+username);
//        RegisterEntity registerEntity = riderRepository.findByName(username).orElseThrow(
//                () -> new UsernameNotFoundException("user name not foudn excpetion " + username));
////        System.out.println(registerEntity.getAuthorities());
////        System.out.println("regsiter authority" + registerEntity.getAuthorities());
//
//
//        List<SimpleGrantedAuthority> collect = registerEntity.getAuthorities().stream()
//                .map(simple -> new SimpleGrantedAuthority(simple.getName()))
//                .collect(Collectors.toList());
//
//        //List<SimpleGrantedAuthority> simpleGrantedAuthorities =
//          //      List.of(new SimpleGrantedAuthority(registerEntity.getRoles()));
//
//        User user = new User(registerEntity.getName(), registerEntity.getPassword(), collect);
//        return user;
//    }
//}
//
