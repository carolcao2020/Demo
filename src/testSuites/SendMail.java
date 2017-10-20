package testSuites;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create one property object
		Properties props = new Properties();
		
		//Setting Mail Server information, smtp host name
		props.put("mail.smtp.host", "smtp.qq.com");
		
		//Setting socket factory port number
		props.put("mail.smtp.socketFactory.port", "465");
		
		//Setting socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		//Setting identity verification
		props.put("mail.smtp.auth", "true");
		
		//Setting smtp port number,qq's port number is 25
		props.put("mail.smtp.port", "25");
		
		//identity verification
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("530662953@qq.con","yxhpvpeifamnbhfh");
			}
		});
		try{
			
			//Create a MimeMessage class instance
			Message message = new MimeMessage(session);
			
			//Setting sender's mail address
			message.setFrom(new InternetAddress("530662953@qq.com"));
			
			//Setting recipient's mail address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("530662953@qq.com"));
			
			//Setting Mail subjet
			message.setSubject("Testing sending mail");
			
			//Create a MimeBodyPart object and add content to it
			BodyPart messageBodyPart1 = new MimeBodyPart();
			
			//Setting message body content
			messageBodyPart1.setText("This is the message body");
			
			//Create another MimeBodyPart object to add content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			
			//Setting message attachment file path
			String filename = ".\\test-output\\emailable-report.html";
			
			//Create a datasource object and deliver the file
			DataSource source = new FileDataSource(filename);
			
			//Setting handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
			
			//Loading files
			messageBodyPart2.setFileName(filename);
			
			//Create a MimeMultipart class object instance
			Multipart multipart = new MimeMultipart();
			
			//Add message body content 1
			multipart.addBodyPart(messageBodyPart1);
			
			//Add message body content 2
			multipart.addBodyPart(messageBodyPart2);
			
			//Setting content
			message.setContent(multipart);
			
			//Finally send the mail
			Transport.send(message);
			System.out.println("=====message has been sent successfully=====");
			
		}catch (MessagingException e){
			throw new RuntimeException(e);
			
		}
	}
}
