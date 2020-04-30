package com.mycompany.service;

import com.mycompany.entity.User;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceInter userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getByEmail(email);
        if (user != null) {
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(email);

            builder.disabled(false);
            builder.password(user.getPassword());

            String[] authoritiesArr = new String[]{"USER", "ADMIN"}; //Authority`leri biz ozumuz bazadan chekmeliyik eslinde
            builder.authorities(authoritiesArr);

            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
