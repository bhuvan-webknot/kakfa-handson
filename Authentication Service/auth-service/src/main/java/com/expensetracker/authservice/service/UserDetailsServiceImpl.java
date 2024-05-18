package com.expensetracker.authservice.service;

import com.expensetracker.authservice.dtos.UserInfoDto;
import com.expensetracker.authservice.entity.UserInfo;
import com.expensetracker.authservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.UUID;

@Data
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CustomUserDetails(userInfo);
    }

    public UserInfo checkIfUserAlreadyExists(UserInfoDto userInfoDto){
        return userRepository.findByUsername(userInfoDto.getUsername()).orElse(null);
    }

    public Boolean signUpUser(UserInfoDto userInfoDto){
        if(checkIfUserAlreadyExists(userInfoDto)==null){
            userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
            String userId = UUID.randomUUID().toString();
            userRepository.save(new UserInfo(userId,userInfoDto.getUsername(),userInfoDto.getPassword(),userInfoDto.getRefreshToken(),new HashSet<>()));
            return true;
        }
        return false;
    }
}
