package com.lambdaschool.javadeployshoppingcart.services;
import com.lambdaschool.javadeployshoppingcart.exceptions.ResourceNotFoundException;
import com.lambdaschool.javadeployshoppingcart.models.User;
import com.lambdaschool.javadeployshoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "securityUserDetails")
public class SecurityUserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username.toLowerCase());

        if (user == null) {
            throw new ResourceNotFoundException("Invalid username or password");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthority());
    }
}