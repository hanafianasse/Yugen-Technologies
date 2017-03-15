package fr.univbrest.dosi.spi.controller;

import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.spi.bean.Authentification;
import fr.univbrest.dosi.spi.exception.SPIException;
import fr.univbrest.dosi.spi.service.AuthentificationService;

@RestController
@RequestMapping(value = "/authentification")
@Api(value = "authentification", description = "Description de la ressource authentification.")
public class AuthentificationController {

	@Autowired
	private AuthentificationService authentificationService;

	@RequestMapping(value = "/auth", method = RequestMethod.POST, headers = "Accept=application/json")
	public void authentifier(final HttpServletRequest request, @RequestBody final Authentification user) {
		final Authentification authentification = authentificationService.authentifier(user.getLoginConnection(), user.getMotPasse()) ; 
		if (authentification != null) {
			request.getSession().setAttribute("user", authentification);
		} else {
			request.getSession().removeAttribute("user");
			throw new SPIException("impossible de s'authentifier");
		}
	}

	@RequestMapping(value = "/user")
	public Authentification users(final HttpServletRequest request, final HttpServletResponse response) {
		final Authentification authentification = (Authentification) request.getSession().getAttribute("user");
		return authentification;
	}

	@RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
	public void authentifier(final HttpServletRequest request) {
		request.getSession().removeAttribute("authentification");
	}

}