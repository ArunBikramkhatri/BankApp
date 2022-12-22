package com.bankapplication.UserDetails;

import com.bankapplication.Entities.User;
import com.bankapplication.Services.Userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailsService implements UserDetailsService {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private Userservices userServices;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = userServices.findUser(username);

        //System.out.println(user.toString());
        if (user == null) {
            throw new UsernameNotFoundException("USer Not found");

        }
        return new CustomUserDetails(user);
    }
}
