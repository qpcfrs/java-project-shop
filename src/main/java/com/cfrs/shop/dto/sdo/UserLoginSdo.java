package com.cfrs.shop.dto.sdo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginSdo {
    private String userName;
    private Long userId;
    private String role;
}
