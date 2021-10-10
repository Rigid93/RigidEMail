package com.rigid.email.service;

import com.rigid.email.model.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Slf4j
@Component
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleEmail(String to, String subject, String content) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("from@from.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
            javaMailSender.send(message);
        } catch (Throwable th) {
            log.error("Unexpected exception in sending simple massage", th);
        }
    }

    public void sendTestMail(String email, String subject, String content) {
        log.info("Sending test mail to: " + email + ", subject: " + subject + ", content: " + content);
        this.sendSimpleEmail(email, subject, content);
    }

    public void sendSimpleEmailWithAttachment(String to, String subject, String text, List<Attachment> attachmentList) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("from@from.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            if (attachmentList != null)
                for (Attachment attachment : attachmentList) {
                    helper.addAttachment(attachment.getAttachmentName(), attachment.getAttachmentData());
                }
            javaMailSender.send(message);
        } catch (Throwable th) {
            log.error("Unexpected exception in sending simple email with attachment", th);
        }
    }
}