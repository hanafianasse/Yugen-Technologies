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
<<<<<<< HEAD
=======
		mapBouchonUser.put("SpiUser", new User("SpiUser", "spiuser", Arrays.asList("Admin")));
>>>>>>> 10d2b52ea12629dde9c99c7d350505c9ca5f492b
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
