package com.myskal.website.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendVerificationEmail(String recipientEmail, String verificationLink) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(recipientEmail);
            message.setSubject("Email Verification");
            message.setText("Please click on the following link to verify your email address:\n" + verificationLink);
            javaMailSender.send(message);
            System.out.println("Verification email sent successfully.");
        } catch (MailException e) {
            System.err.println("Error sending verification email: " + e.getMessage());
        }
    }

    public void sendVerificationEmail(Object email) {
    }
}
