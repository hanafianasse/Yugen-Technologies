/**
 * 
 */
package fr.univbrest.dosi.spi.controller;

import io.swagger.annotations.Api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.spi.bean.UniteEnseignement;
import fr.univbrest.dosi.spi.service.UniteEnseignementService;

/**
 * @author Chobaz
 *
 * 22 mars 2017
 */
@RestController
@RequestMapping(value = "/uniteEnseignement")
@Api(value = "uniteEnseignement", description = "Description de la ressource uniteEnseignement.")
public class UniteEnseignementController
{
	@Autowired
	private UniteEnseignementService uniteEnseignementService;

	@RequestMapping(method = RequestMethod.POST)
	public UniteEnseignement addUniteEnseignement(@RequestBody UniteEnseignement uniteEnseignement)
	{
		return uniteEnseignementService.addUniteEnseignement(uniteEnseignement);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public UniteEnseignement updateUniteEnseignement(
			@RequestBody UniteEnseignement uniteEnseignement)
	{
		return uniteEnseignementService.updateUniteEnseignement(uniteEnseignement);
	}

	@RequestMapping(value = "/{idUniteEnseignement}", method = RequestMethod.DELETE)
	public void deleteUniteEnseignement(
			@PathVariable("idUniteEnseignement") Long idUniteEnseignement)
	{
		uniteEnseignementService.deleteUniteEnseignement(idUniteEnseignement);
	}

	@RequestMapping(value = "/{idUniteEnseignement}", method = RequestMethod.GET)
	public UniteEnseignement getUniteEnseignement(
			@PathVariable("idUniteEnseignement") Long idUniteEnseignement)
	{
		return uniteEnseignementService.getUniteEnseignement(idUniteEnseignement);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<UniteEnseignement> getAll()
	{
		return (Collection<UniteEnseignement>) uniteEnseignementService.getAll();
	}

}

