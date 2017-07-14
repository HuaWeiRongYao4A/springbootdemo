package com.example.demo.rabbitmq;

import com.example.demo.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Administrator on 2017/7/9.
 */
@Configuration
@RabbitListener(queues = "user.email.routing-key")
public class RabbitmqEmailReceive {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.fromMail.address}")
    private String from;

    @RabbitHandler
    public void sendEmailToUser(User user) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo("1245195729@qq.com");
            helper.setSubject("铁哥你好");
            String text = "<html>\n" +
                    "<body>\n" +
                    "    <h3>hello 老铁 ! 这是你的哈佛录取通知书!</h3>\n" +
                    "<p>" + "请笑纳" + "</p>" +
                    "</body>\n" +
                    "</html>";
            helper.setText(text, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("发送html邮件时发生异常");
        }
    }

    @RabbitHandler
    public void str(String hello) {
        System.out.println("rabbitmq message str " + hello);
    }

//    @RabbitHandler
//    public void str2(String hello) {
//        System.out.println("rabbitmq message str2 " + hello);
//    }
}
