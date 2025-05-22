package com.cfrs.shop.controller;

import com.cfrs.shop.dto.sdi.UserLoginSdi;
import com.cfrs.shop.dto.sdi.UserRegisterSdi;
import com.cfrs.shop.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Validated
@RequestMapping(value = "user")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterSdi request) throws Exception {
        userService.registerUser(request);
        return ResponseEntity.ok(Map.of("message", "Đăng ký thành công"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginSdi request) throws Exception{
        return ResponseEntity.ok().body(userService.login(request));
    }
}