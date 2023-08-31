package com.example.hotelreservation.controller;

import com.example.hotelreservation.domains.vo.UserVO;
import com.example.hotelreservation.service.SMSService;
import com.example.hotelreservation.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@Log4j2
public class UserController {
    @Autowired
    private SMSService smsService;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public void get_login() {

    }

    @PostMapping("/login")
    public void post_login() {

    }

    /* 회원가입 */
    @GetMapping("/join")
    public void get_join() {

    }

    @PostMapping("/join")
    public String post_join(
            @Validated UserVO userVO, BindingResult result
    ) {
        System.out.println(userVO);
        if(result.hasErrors()) {
            log.error("USER_VO의 형식이 맞지 않음");
            log.info(userVO);
            return "redirect:/user/join";
        }
        userService.join_user(userVO);
        return "redirect:/"; // /home
    }

    @GetMapping("/mypage")
    public void get_mypage_info() {

    }

    @GetMapping("/mypage/reservation")
    public void get_mypage_reservation() {

    }

    @GetMapping("/mypage/sale")
    public void get_mypage_sale() {

    }

    @GetMapping("/mypage/heart")
    public void get_mypage_heart() {

    }

    @GetMapping("/sms")
    @ResponseBody
    public HttpStatus sms_test(@RequestParam String telNum) {
        return smsService.send_sms("telNum");

    }
}
