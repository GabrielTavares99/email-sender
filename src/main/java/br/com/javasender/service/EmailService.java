package br.com.javasender.service;

import br.com.javasender.config.Constants;
import br.com.javasender.entity.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import br.com.javasender.util.FileUtil;

import java.io.File;
import java.util.Map;

import static br.com.javasender.config.Constants.SMTP_PORT;

public class EmailService {
    private ClassLoader classLoader = ClassLoader.getSystemClassLoader();

    public void sendEmail(Email emailTo) throws EmailException {
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setDebug(false);

            File file = new File(classLoader.getResource(emailTo.getHtmlName()).getFile());
            String htmlEmailContent = FileUtil.fileToText(file.getAbsolutePath());
            htmlEmailContent = setEmailFields(emailTo, htmlEmailContent);

            if (emailTo.getAttachments().size() > 0) {
                for (String attachmentPath : emailTo.getAttachments())
                    email.attach(new File(classLoader.getResource(attachmentPath).getFile()));
                email.addPart(htmlEmailContent, "text/html; charset=utf-8");
            } else
                email.setContent(htmlEmailContent, "text/html; charset=utf-8");

            email.setHostName(Constants.SMTP_HOSTNAME);
            email.setSmtpPort(SMTP_PORT);

            email.addTo(emailTo.getToEmail());

            email.setFrom(Constants.SYSTEM_EMAIL, Constants.SYSTEM_NAME);

            email.setSubject(emailTo.getSubject());

            System.out.println("Authentication on email server...");
            email.setSSLOnConnect(true);
            email.setAuthentication(Constants.SYSTEM_EMAIL, Constants.SYSTEM_EMAIL_PASSWORD);
            System.out.println("Sending...");
            email.send();
            System.out.println("Email sent!");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private String setEmailFields(Email email, String htmlEmTexto) {
        for (Map.Entry<String, String> attribute : email.getHtmlAttributes().entrySet())
            htmlEmTexto = htmlEmTexto.replace("#" + attribute.getKey(), attribute.getValue());
        return htmlEmTexto;
    }

}
