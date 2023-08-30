package com.example.hotelreservation.domains.dto;

import com.example.hotelreservation.domains.vo.RatingVO;
import com.example.hotelreservation.domains.vo.RoomVO;
import com.example.hotelreservation.domains.vo.RoomImagesVO;

import java.util.List;

public class RoomDTO {
    private int roomNo;
    private RoomVO roomVO;
    private List<RatingVO> ratingVO;
    private List<RoomImagesVO> roomImagsVOS;
}