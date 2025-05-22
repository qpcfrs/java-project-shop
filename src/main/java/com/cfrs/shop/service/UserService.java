package com.cfrs.shop.service;

import com.cfrs.shop.domain.User;
import com.cfrs.shop.dto.sdi.UserLoginSdi;
import com.cfrs.shop.dto.sdi.UserRegisterSdi;
import com.cfrs.shop.dto.sdi.UserUpdateSdi;
import com.cfrs.shop.dto.sdo.UserLoginSdo;

import java.util.List;

public interface UserService {
    void registerUser(UserRegisterSdi request) throws Exception;
    UserLoginSdo login(UserLoginSdi request) throws Exception;

    List<User> findAll();
    User save(User user);
    User update(Long id, UserUpdateSdi user);
    void delete(Long id);
}
