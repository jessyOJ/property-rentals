package com.flexisaf.property_rentals.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flexisaf.property_rentals.entity.Role;
import com.flexisaf.property_rentals.entity.User;
import com.flexisaf.property_rentals.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class MyUserDetailsService implements UserDetailsService {
//	@Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // For demonstration, a hardcoded user
//        if ("user".equals(username)) {
//            return User.withUsername("user")
//                    .password("$2a$10$Dow1lJ5mpgO5glWThmk90OJh8.OUBTwSuYUNqZ0zbhpzUMrYZ1Z5i") // "password" encoded with BCrypt
//                    .roles("OWNER")
//                    .build();
//        } else {
//            throw new UsernameNotFoundException("User not found");
//        }
//    }
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired  
	private HttpServletRequest request;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).get();

        if (user != null) {
        	request.getSession().setAttribute("USER_ID", user.getId());
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
		Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
	}
}
