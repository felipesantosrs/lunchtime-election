/**
 *
 * Felipe
 */
package config;

import java.util.Date;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import entity.User;

/**
 * Send E-mail
 * @author Felipe
 *
 */
public class SendEmail {
	
	/**
	 * This method is responsable to send e-mail
	 * @param userList
	 * @param restaurantName
	 * @throws EmailException
	 */
	public void send(List<User> userList, String restaurantName) throws EmailException {

		SimpleEmail email = new SimpleEmail();
		System.out.println("hostname...");
		for (User user : userList) {
			email.addTo(user.getUserEmail(), user.getUserName());
		}

		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		// Configure o seu email do qual enviará
		email.setFrom("meurestaurantedb@gmail.com", "eleição");
		// Adicione um assunto
		email.setSubject("Restaurante eleito - " + new Date());
		// Adicione a mensagem do email
		email.setMsg("O restaurante eleito no dia " + new Date() + " foi " + restaurantName);
		// Para autenticar no servidor é necessário chamar os dois métodos
		// abaixo
		System.out.println("autenticando...");
		email.setSSL(true);
		email.setAuthentication("meurestaurantedb", "1020304050607080");
		System.out.println("enviando...");
		email.send();
		System.out.println("Email enviado!");
	}
}
