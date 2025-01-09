//package com.project.LearnLynks;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//
//import java.io.IOException;
//
////public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
////
////    @Override
////    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//////        boolean isAdmin = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
////        boolean isTeacher = authentication.getAuthorities().stream()
////                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_TEACHER"));
////        boolean isStudent = authentication.getAuthorities().stream()
////                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_STUDENT"));
////        if (isTeacher) {
////            setDefaultTargetUrl("/teacher/home");
////        }
////        if (isStudent) {
////            setDefaultTargetUrl("/student/home");
////        }
////        else{
////            setDefaultTargetUrl("/parent/home");
////        }
////        super.onAuthenticationSuccess(request, response, authentication);
////    }
////}
//
//public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//        boolean isTeacher = authentication.getAuthorities().stream()
//                .anyMatch(authority -> authority.getAuthority().equals("ROLE_TEACHER"));
//        boolean isStudent = authentication.getAuthorities().stream()
//                .anyMatch(authority -> authority.getAuthority().equals("ROLE_STUDENT"));
//
//        if (isTeacher) {
//            setDefaultTargetUrl("/teacher/home");
//        } else if (isStudent) {
//            setDefaultTargetUrl("/student/home");
//        } else {
//            setDefaultTargetUrl("/parent/home");
//        }
//
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//}
