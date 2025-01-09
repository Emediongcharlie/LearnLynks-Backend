//package com.project.LearnLynks;//package com.project.LearnLynks;
//
//import com.project.LearnLynks.models.Users;
//import com.project.LearnLynks.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
////
////
////import com.project.LearnLynks.models.Users;
////import com.project.LearnLynks.repositories.UserRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////import org.springframework.stereotype.Service;
////
////import java.util.Optional;
////
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Users> usersOptional = userRepository.findByUsername(username);
//        if (usersOptional.isPresent()) {
//            var ourUser = usersOptional.get();
//           return User.builder()
//                    .username(ourUser.getUsername())
//                    .password(ourUser.getPassword())
//                    .roles(getRoles(ourUser))
//                    .build();
//        }
//        else{
//            throw new UsernameNotFoundException(username);
//        }
//    }
//
//    private String[] getRoles(Users ourUser) {
//        if(ourUser.getRole() == null){
//            return new String[]{"TEACHER"};
//        } else{
//            return new String[]{ourUser.getRole().name()};
//        }
//    }
//
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        UserDetails teacher = User.builder()
////                .username("teacher")
////                .password(new BCryptPasswordEncoder().encode("password"))
////                .roles("TEACHER")
////                .build();
////
////        UserDetails student = User.builder()
////                .username("student")
////                .password(new BCryptPasswordEncoder().encode("password"))
////                .roles("STUDENT")
////                .build();
////
////        UserDetails parent = User.builder()
////                .username("parent")
////                .password(new BCryptPasswordEncoder().encode("password"))
////                .roles("PARENT")
////                .build();
////
////        return new InMemoryUserDetailsManager(teacher, student, parent);
////    }
//}
////
////
