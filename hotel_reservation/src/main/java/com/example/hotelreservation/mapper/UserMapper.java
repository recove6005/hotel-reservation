package com.example.hotelreservation.mapper;

import com.example.hotelreservation.domains.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 로그인 시 유저 조회
    UserVO get_user(String id);
    // 회원가입
    void join_user(UserVO vo);
}
