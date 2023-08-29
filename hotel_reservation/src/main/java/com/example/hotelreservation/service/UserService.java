package com.example.hotelreservation.service;

import com.example.hotelreservation.domains.vo.UserVO;
import com.example.hotelreservation.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 유저 회원가입
    public void join_user(UserVO userVO) {
        // password 인코딩
        userVO.setPw(passwordEncoder.encode(userVO.getPw()));
        userMapper.join_user(userVO);
    }
}
