package com.example.hotelreservation.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReserveMapper {
    void reserve_room();
}
