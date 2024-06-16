package cleancode.infrastructure;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cleancode.port.SenderService;

public final class EMailSender implements SenderService{
    private final String smtpHost;
    private final int smtpPort;
    private final String sender;

    public EMailSender(String smtpHost, int smtpPort, String sender){
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.sender = sender;
    }

    @Override
    public void send(EMailMessage emailMessage) throws MessagingException {
        // Create a mail session
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
        Session session = Session.getInstance(props, null);

        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(sender));

        msg = emailMessage.buildMessage(msg);

        // Send the message
        Transport.send(msg);
    }


}
