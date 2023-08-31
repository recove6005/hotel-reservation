package com.example.hotelreservation.controller;


import com.example.hotelreservation.domains.dto.RoomDTO;
import com.example.hotelreservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    @ResponseBody
    public List<RoomDTO> get_all_rooms() {
        return roomService.get_all_rooms();
    }

    @GetMapping("/image/{imageName}")
    public ResponseEntity<Resource> get_room_image_file(
            @PathVariable("imageName") String imageName
    ) throws IOException {
        return roomService.get_room_image_file(imageName);
    }
}