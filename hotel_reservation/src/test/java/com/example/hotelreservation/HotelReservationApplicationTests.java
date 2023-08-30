package com.example.hotelreservation;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.hotelreservation.mapper.RoomMapper;
import com.example.hotelreservation.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.System.out;
import static java.lang.System.setOut;

@SpringBootTest
class HotelReservationApplicationTests {
    @Autowired
    RoomMapper roomMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {

        // System.out.println(roomMapper.get_all_rooms());
        System.out.println(userMapper.get_user("seluser"));
    }

}
