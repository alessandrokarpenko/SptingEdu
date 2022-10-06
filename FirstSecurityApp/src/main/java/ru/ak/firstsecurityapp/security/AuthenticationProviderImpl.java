//package ru.ak.firstsecurityapp.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import ru.ak.firstsecurityapp.services.PersonDetailsService;
//
//import java.util.Collections;
//
//@Component
//public class AuthenticationProviderImpl implements AuthenticationProvider {
//
//    private final PersonDetailsService personDetailsService;
//
//    @Autowired
//    public AuthenticationProviderImpl(PersonDetailsService personDetailsService) {
//        this.personDetailsService = personDetailsService;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String name = authentication.getName();
//        UserDetails userDetails = personDetailsService.loadUserByUsername(name);
//        String password = authentication.getCredentials().toString();
//
//        if (password.equals(userDetails.getPassword())) {
//            return new UsernamePasswordAuthenticationToken(userDetails, password, Collections.emptyList());
//        } else {
//            throw new BadCredentialsException("Incorrect password");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//    }
//
//}
