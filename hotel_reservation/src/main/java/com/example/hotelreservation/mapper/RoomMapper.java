package com.example.hotelreservation.mapper;

import com.example.hotelreservation.domains.dto.RoomDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    List<RoomDTO> get_all_rooms();

}
