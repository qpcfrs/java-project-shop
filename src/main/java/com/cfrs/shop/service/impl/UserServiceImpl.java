package com.cfrs.shop.service.impl;

import com.cfrs.shop.domain.User;
import com.cfrs.shop.dto.sdi.UserLoginSdi;
import com.cfrs.shop.dto.sdi.UserRegisterSdi;
import com.cfrs.shop.dto.sdi.UserUpdateSdi;
import com.cfrs.shop.dto.sdo.UserLoginSdo;
import com.cfrs.shop.repository.UserRepository;
import com.cfrs.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public void registerUser(UserRegisterSdi request) throws Exception {
        User userFind = userRepository.findByEmail(request.getEmail()).orElse(null);
        if (userFind != null) {
            throw new Exception("Email đã tồn tại");
        }
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
    }

    @Override
    public UserLoginSdo login(UserLoginSdi request) throws Exception {
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);
        if (user == null) {
            throw new Exception("Tài khoản không tồn tại.");
        }
        Boolean checkPassword = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!checkPassword) {
            throw new Exception("Email hoặc mật khẩu không đúng. Vui lòng kiểm tra lại.");
        }
        return UserLoginSdo.builder()
                .userName(user.getName())
                .userId(user.getId())
                .role(user.getRole())
                .build();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, UserUpdateSdi user) {
        User userFind = userRepository.findById(id).orElse(null);
        if (userFind != null) {
            userFind.setName(user.getName());
            userFind.setEmail(user.getEmail());
            userFind.setRole(user.getRole());
            return userRepository.save(userFind);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
