package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Administrator on 2017/6/26.
 */
@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserService userService;

    @Value("${mail.fromMail.address}")
    private String from;

    /** 普通邮件发送 ***/
    @RequestMapping("send")
    public String send(String receiveEmail, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(receiveEmail);
        message.setSubject("律师同行");
        message.setText(content);
        try {
            javaMailSender.send(message);
            System.out.println("邮箱发送成功");
        } catch (Exception e) {
            System.out.println("邮箱发送异常");
        }
        return "success";
    }

    /** html邮件发送 ***/
    @RequestMapping("sendHtmlEmail")
    public String sendHtmlEmail(String receiveEmail, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(receiveEmail);
            helper.setSubject("律师同行");
            String text = "<html>\n" +
                    "<body>\n" +
                    "    <h3>hello 老铁 ! 这是你的哈佛录取通知书!</h3>\n" +
                    "<p>" + content + "</p>" +
                    "</body>\n" +
                    "</html>";
            helper.setText(text, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("发送html邮件时发生异常");
        }
        return "success";
    }

    /** rabbitmq邮件发送 ***/
    @GetMapping("sendRabbitmqEmail")
    public String sendRabbitmqEmail() {
        User user = new User("nice-user", "123456");
        userService.sendEmailToUserQueue(user);
        return "success";
    }
}
