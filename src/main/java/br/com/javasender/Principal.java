package br.com.javasender;

import br.com.javasender.entity.Email;
import br.com.javasender.service.EmailService;
import org.apache.commons.mail.EmailException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws EmailException {

        Email email = new Email();

        HashMap<String, String> htmlParams = new HashMap<>();
        htmlParams.put("NAME_PARAM", "José");
        email.setHtmlAttributes(htmlParams);

        email.setHtmlName("email-html/welcome.html");
        email.setSubject("Welcome new user");
        email.setToEmail("d5zmf@max-mail.com");

        EmailService emailService = new EmailService();
        List<String> attachments = new ArrayList<>();
        attachments.add("email-attachment/attachment-example.jpg");
        email.setAttachments(attachments);
        emailService.sendEmail(email);
    }
}
