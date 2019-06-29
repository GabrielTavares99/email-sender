package br.com.javasender.entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Email {

    private Integer id;
    private String toEmail;
    private String subject;
    private String htmlName;
    private Boolean send;
    private LocalDateTime dateSend;
    private Map<String, String> htmlAttributes;
    private List<String> attachments;

    public Email() {
        this.htmlAttributes = new HashMap<>();
    }

    public Boolean getSend() {
        return send;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHtmlName() {
        return htmlName;
    }

    public void setHtmlName(String htmlName) {
        this.htmlName = htmlName;
    }

    public boolean isSend() {
        return send;
    }

    public void setSend(Boolean send) {
        this.send = send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public LocalDateTime getDateSend() {
        return dateSend;
    }

    public void setDateSend(LocalDateTime dateSend) {
        this.dateSend = dateSend;
    }

    public Map<String, String> getHtmlAttributes() {
        return htmlAttributes;
    }

    public void setHtmlAttributes(Map<String, String> htmlAttributes) {
        this.htmlAttributes = htmlAttributes;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }
}
