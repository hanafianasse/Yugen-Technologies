package fr.univbrest.dosi.spi.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.User;

@Service
public class UserService {

	private final Map<String, User> mapBouchonUser;

	public UserService() {
		mapBouchonUser = new HashMap<String, User>();
		mapBouchonUser.put("chakib", new User("chakib", "1234", Arrays.asList("Admin")));
		mapBouchonUser.put("zou", new User("zou", "1234", Arrays.asList("visiteur")));
		mapBouchonUser.put("mouad", new User("mouad", "1234", Arrays.asList("Prof")));
		mapBouchonUser.put("SpiUser", new User("SpiUser", "spiuser", Arrays.asList("Admin")));
<<<<<<< HEAD

=======
>>>>>>> a5e1f82f5e6372dbd08d48092ace79c4b366efb6
	}

	/**
	 * @param login
	 * @param pwd
	 * @return
	 */
	public User authentifier(final String login, final String pwd) {
		final User user = mapBouchonUser.get(login);
		if (user != null && user.getPwd().equals(pwd)) {
			return user;
		}
		return null;
	}

}
