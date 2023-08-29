package com.example.hotelreservation.domains.vo;

import com.example.hotelreservation.enums.RoomState;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
@NoArgsConstructor
public class RoomVO {
    private int no;
    private String id;
    private String title;
    private int price;
    private String text;
    private RoomState state;
}
