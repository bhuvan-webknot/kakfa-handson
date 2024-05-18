package com.expensetracker.authservice.dtos;

import com.expensetracker.authservice.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto extends UserInfo {
    private String username;
    private Long phoneNumber;
    private String email;
}
