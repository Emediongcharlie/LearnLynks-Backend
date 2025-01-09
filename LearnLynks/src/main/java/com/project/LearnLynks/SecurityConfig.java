//package com.project.LearnLynks;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//
////
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationProvider;
////import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
////import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////import org.springframework.security.web.SecurityFilterChain;
////
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
////
//    @Autowired
//    private MyUserDetailsService myUserDetailsService;
////
//    public SecurityConfig(MyUserDetailsService myUserDetailsService) {
//        this.myUserDetailsService = myUserDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(registry -> {
//                    registry.requestMatchers("/home", "/register/**").permitAll();
//                    registry.requestMatchers("/teacher/**").hasRole("TEACHER");
//                    registry.requestMatchers("/upload", "/download/**").hasRole("TEACHER");
//                    registry.requestMatchers("/student/**", "/register-student").hasRole("STUDENT");
//                    registry.requestMatchers("/parent/**").hasRole("PARENT");
//                    registry.anyRequest().authenticated();
//                })
//                .build();
//    }
//////               .formLogin(httpSecurityFormLoginConfigurer -> {
//////                   httpSecurityFormLoginConfigurer
//////                           .loginPage("/login")
//////                           .successHandler(new AuthenticationSuccessHandler())
//////                           .permitAll();
//////               })
////////               .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
//////               .build();
//////    }
////
////
////        @Bean
////        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////            return http
////                    .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for simplicity in this example
////                    .authorizeHttpRequests(auth -> auth
////                            // Publicly accessible endpoints
////                            .requestMatchers("/home", "/register/**", "/login").permitAll()
////
////                            // Teacher-specific endpoints
////                            .requestMatchers("/teacher/**").hasRole("TEACHER")
////                            .requestMatchers("upload", "/send-emails").hasRole("TEACHER")
////
////                            // Student-specific endpoints
////                            .requestMatchers("/student/**").hasRole("STUDENT")
////
////                            // Parent-specific endpoints
////                            .requestMatchers("/parent/**").hasRole("PARENT")
////
////                            // Fallback for any other requests
////                            .anyRequest().authenticated()
////                    )
////                    .formLogin(login -> login
////                            .loginPage("/login")
////                            .successHandler(new AuthenticationSuccessHandler()) // Redirect users based on roles
////                            .permitAll()
////                    )
////                    .logout(logout -> logout
////                            .logoutUrl("/logout")
////                            .logoutSuccessUrl("/login?logout")
////                            .invalidateHttpSession(true)
////                            .deleteCookies("JSESSIONID")
////                            .permitAll()
////                    )
////                    .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
////                    .build();
////        }
////
////
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return myUserDetailsService;
//    }
////
////        @Bean
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
//
//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(myUserDetailsService);
//        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//        return provider;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
