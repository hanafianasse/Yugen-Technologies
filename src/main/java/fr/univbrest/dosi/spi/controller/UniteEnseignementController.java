
package fr.univbrest.dosi.spi.controller;

import fr.univbrest.dosi.spi.bean.UniteEnseignement;
import fr.univbrest.dosi.spi.bean.UniteEnseignementPK;
import fr.univbrest.dosi.spi.service.UniteEnseignementService;
import io.swagger.annotations.Api;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chobaz
 *
 *         22 mars 2017
 */
@RestController
@RequestMapping(value = "/uniteEnseignement")
@Api(value = "uniteEnseignement", description = "Description de la ressource uniteEnseignement.")
public class UniteEnseignementController
{
	@Autowired
	private UniteEnseignementService uniteEnseignementService;

	@RequestMapping(method = RequestMethod.POST)
	public UniteEnseignement addUniteEnseignement(
			@RequestBody UniteEnseignement uniteEnseignement)
	{
		return uniteEnseignementService.addUniteEnseignement(uniteEnseignement);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public UniteEnseignement updateUniteEnseignement(
			@RequestBody UniteEnseignement uniteEnseignement)
	{
		return uniteEnseignementService
				.updateUniteEnseignement(uniteEnseignement);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteUniteEnseignement(
			@RequestBody UniteEnseignementPK uniteEnseignementPK)
	{
		uniteEnseignementService.deleteUniteEnseignement(uniteEnseignementPK);
	}

	@RequestMapping(value = "/{codeFormation}/{codeUe}", method = RequestMethod.GET)
	public UniteEnseignement getUniteEnseignement(
			@PathVariable("codeFormation") String codeFormation,
			@PathVariable("codeUe") String codeUe)
	{
		UniteEnseignementPK uniteEnseignementPK = new UniteEnseignementPK(
				codeFormation, codeUe);

		return uniteEnseignementService
				.getUniteEnseignement(uniteEnseignementPK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<UniteEnseignement> getAll()
	{
		return (Collection<UniteEnseignement>) uniteEnseignementService
				.getAll();
	}

	@RequestMapping(value = "getByCodeFormation/{codeFormation}", method = RequestMethod.GET)
	public List<UniteEnseignement> getByCodeFormation(
			@PathVariable("codeFormation") String codeFormation)
	{
		return uniteEnseignementService
				.getByUniteEnseignementPK_CodeFormation(codeFormation);
	}
	
	// Nombre des UE
			@RequestMapping(value = "/nombreUE", method = RequestMethod.GET)
			public String nombreUE()
			{
				return String.valueOf(uniteEnseignementService.nombreUE());		}
		

}
