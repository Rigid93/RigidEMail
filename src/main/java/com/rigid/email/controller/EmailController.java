package com.rigid.email.controller;

import com.rigid.email.service.EmailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/email/")
public class EmailController {

    @Autowired
    EmailServiceImpl emailService;

    @GetMapping("send/test/{prefix}/{postfix}/{domain}")
    public void sendTestMail(@PathVariable String prefix, @PathVariable String postfix, @PathVariable String domain) {
        String emailAddressTo = prefix + "@" + postfix + "." + domain;
        log.info("Sending test email to: " + emailAddressTo);
        emailService.sendSimpleMessage(emailAddressTo,
                "Rigid test mail - subject",
                "Rigid test mail - content");
    }

    @PostMapping("send/simple")
    public void sendSimpleEmail() {
        //TODO
        emailService.sendSimpleMessage("to", "temat", "content");
    }
}
