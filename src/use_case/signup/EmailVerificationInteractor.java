package use_case.signup;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Implements email verification using the Java Mail API.
 */

public class EmailVerificationInteractor implements EmailVerificationInputBoundary {

    final EmailVerificationOutputBoundary emailVerificationPresenter;

    /**
     * Constructs an EmailVerificationInteractor with the given presenter.
     *
     * @param emailVerificationPresenter the presenter for email verification
     */
    public EmailVerificationInteractor(EmailVerificationOutputBoundary emailVerificationPresenter) {
        this.emailVerificationPresenter = emailVerificationPresenter;
    }

    /**
     * Executes the email verification process.
     * Configures and sends a verification email with a generated code to the specified email address.
     *
     * @param email the input data containing the email address to send the verification to
     * @throws Exception if an error occurs during email sending
     */
    @Override
    public void execute(EmailVerificationInputData email) throws Exception {

        // Sending email configuration. Send email from QQ smtp
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
        session.setDebug(true); // Set to debug mode, view detailed sending log

        Random rand = new Random();
        int code = rand.nextInt(900000) + 100000;
        String messagetosend = Integer.toString(code);

        String utEmail = email.getEmail() + "@mail.utoronto.ca";
        System.out.println(utEmail);

        MimeMessage message = createMimeMessage(session, "3232085039@qq.com", utEmail, "Verify",
                messagetosend);

        Transport transport = session.getTransport();

        transport.connect("3232085039@qq.com", "cwuwfmohzmvddbfa");

        transport.sendMessage(message, message.getAllRecipients());

        transport.close();

        EmailVerificationOutputData emailVerificationOutputData = new EmailVerificationOutputData(String.valueOf(code));
        emailVerificationPresenter.prepareView(emailVerificationOutputData);
    }

    /**
     * Creates a message to be sent to the user.
     *
     * @param session the mail session
     * @param sendMail the sender's email address
     * @param receiveMail the recipient's email address
     * @param subject the subject of the email
     * @param content the content of the email
     * @return the created MimeMessage
     * @throws Exception if an error occurs during message creation
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String subject, String content) throws Exception {
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(sendMail, "email_verification", "UTF-8"));

        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX user", "UTF-8"));

        message.setSubject(subject, "UTF-8");

        message.setContent(content, "text/html;charset=UTF-8");

        message.setSentDate(new Date());

        message.saveChanges();

        return message;
    }

}
