package fr.univbrest.dosi.spi.controller;

import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.spi.bean.User;
import fr.univbrest.dosi.spi.exception.SPIException;
import fr.univbrest.dosi.spi.service.UserService;


@RestController
@RequestMapping(value = "/user")
@Api(value = "user", description = "Description de la ressource user.")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping( method = RequestMethod.GET)
	public User users(final HttpServletRequest request,
			final HttpServletResponse response) {
		final User user = (User) request.getSession().getAttribute("user");
		return user;
	}
	
}



















