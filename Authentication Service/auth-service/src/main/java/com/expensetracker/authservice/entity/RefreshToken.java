package com.expensetracker.authservice.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="tokens_t")
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="token_id")
    public Long tokenId;
    public String token;
    public Instant expiryDate;

    @OneToOne(mappedBy = "refreshToken")
    private UserInfo userInfo;
}
