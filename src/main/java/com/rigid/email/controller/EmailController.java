package com.rigid.email.controller;

import com.rigid.email.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email/")
public class EmailController {

    @Autowired
    EmailServiceImpl emailService;

    @GetMapping("send/test")
    public void sendTestMail(@RequestParam(value = "email") String email,
                             @RequestParam(value = "subject", defaultValue = "Test subject") String subject,
                             @RequestParam(value = "content", defaultValue = "Test content") String content) {
        emailService.sendTestMail(email, subject, content);
    }

    @PostMapping("send/simple")
    public void sendSimpleEmail() {
        //TODO
    }
}
