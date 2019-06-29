package br.com.javasender.config;

public class Constants {

    public static final String SYSTEM_EMAIL = System.getenv("SYSTEM_EMAIL");
    public static final String SYSTEM_EMAIL_PASSWORD = System.getenv("SYSTEM_EMAIL_PASSWORD");
    public static final String SYSTEM_NAME = "My Super Email Sender";
    public static final String SMTP_HOSTNAME = "smtp.gmail.com";
    public static final int SMTP_PORT = 465;

}
