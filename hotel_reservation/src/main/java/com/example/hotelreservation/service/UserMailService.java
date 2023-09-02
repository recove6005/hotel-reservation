package com.example.hotelreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class UserMailService {
    @Autowired
    private JavaMailSender mailSender;

    public void send_mail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setFrom("lee0398_@naver.com"); // 누가 보내는가?
        helper.setTo("leehan9498@gmail.com"); // 누구에게 보내는가?
        helper.setText("hallo, me! It's me."); // 내용은 무엇인가?
        helper.setText("<b>hallo, me! It's me.</b>", true); // 내용을 html로 전송

        // 메세지 발송
        mailSender.send(mimeMessage);
    }

    public void send_mail(String email) {
        // Velocity, Freemarker, Thymeleaf

    }
}
