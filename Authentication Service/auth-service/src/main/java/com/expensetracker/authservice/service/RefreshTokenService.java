package com.expensetracker.authservice.service;


import com.expensetracker.authservice.entity.RefreshToken;
import com.expensetracker.authservice.entity.UserInfo;
import com.expensetracker.authservice.repository.RefreshTokenRepository;
import com.expensetracker.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.ref.Reference;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    public RefreshToken createRefreshToken(String userName){
        UserInfo userInfoExtracted = userRepository.findByUsername(userName).get();
           RefreshToken refreshToken = RefreshToken
                   .builder()
                   .userInfo(userInfoExtracted)
                   .token(UUID.randomUUID().toString())
                   .expiryDate(Instant.now().plusMillis(600000))
                   .build();
           return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException("Refresh Token has expired. Please login again");
        }
        return token;
    }

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }


}
