package use_case;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Use the Java Mail API to implement email verification.
 */

public class EmailVerificationInteractor  implements EmailVerificationInputBoundary{

    public void execute() throws Exception {

        /**
         * Sending email configuration.
         * Send email from QQ smtp
         */
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        props.setProperty("mail.smtp.auth", "true");


        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);

        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // Set to debug mode, view detailed sending log

        Random rand = new Random();
        int code = rand.nextInt(900000) + 100000;
        String messagetosend = Integer.toString(code);

        String verifyNum = "100000";

        MimeMessage message = createMimeMessage(session, "3232085039@qq.com", "hanrui.zhang@mail.utoronto.ca", "Verify", messagetosend);

        Transport transport = session.getTransport();

        transport.connect("3232085039@qq.com", "cwuwfmohzmvddbfa");

        transport.sendMessage(message, message.getAllRecipients());

        transport.close();
    }

    /**
     * Create a message used to sent to user.
     * @param session
     * @param sendMail
     * @param receiveMail
     * @param subject
     * @param content
     * @return
     * @throws Exception
     */

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String subject, String content) throws Exception {
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(sendMail, "email_verification", "UTF-8"));

        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX User", "UTF-8"));

        message.setSubject(subject, "UTF-8");

        message.setContent(content, "text/html;charset=UTF-8");

        message.setSentDate(new Date());

        message.saveChanges();

        return message;
    }

}

