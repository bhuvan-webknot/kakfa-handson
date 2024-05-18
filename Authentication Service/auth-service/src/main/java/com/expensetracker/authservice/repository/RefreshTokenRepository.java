package com.expensetracker.authservice.repository;


import com.expensetracker.authservice.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    //Select * from refresh_token where token = ?
    Optional<RefreshToken> findByToken(String token);
}
