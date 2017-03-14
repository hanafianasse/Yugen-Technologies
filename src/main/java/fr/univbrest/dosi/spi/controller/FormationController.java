package fr.univbrest.dosi.spi.controller;

import fr.univbrest.dosi.spi.bean.Formation;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.service.FormationService;
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
 * @author DOSI
 *
 */
@RestController
@RequestMapping(value = "/formation")
@Api(value = "formation", description = "Description de la ressource formation.")
public class FormationController
{
	/**
	 *
	 */
	@Autowired
	private FormationService formationService;

	/**
	 *
	 * @param formation
	 *            l'entité de formation
	 * @return une formation
	 */
	@RequestMapping(method = RequestMethod.POST)
	public final Formation addFormation(@RequestBody final Formation formation)
	{
		return formationService.addFormation(formation);
	}

	/**
	 *
	 * @param formation
	 *            l'entité de formation
	 * @return une formation
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public final Formation updateFormation(@RequestBody final Formation formation)
	{
		return formationService.updateFormation(formation);
	}

	/**
	 *
	 * @param codeFormation
	 *            l'id de formation
	 * @return une formation
	 */
	@RequestMapping(value = "/{codeFormation}", method = RequestMethod.GET)
	public final Formation getFormation(@PathVariable(value = "codeFormation") final String codeFormation)
	{
		return formationService.getFormation(codeFormation);

	}

	/**
	 *
	 * @param codeFormation
	 *            l'id de promotion
	 * @return une liste de promotion
	 */
	@RequestMapping(value = "/{codeFormation}/promotion", method = RequestMethod.GET)
	public final List<Promotion> getPromotionsduneFormation(@PathVariable(value = "codeFormation") final String codeFormation)
	{
		return formationService.getPromotions(codeFormation);
	}

	/**
	 *
	 * @return list de formation
	 */
	@RequestMapping(method = RequestMethod.GET)
	public final Collection<Formation> getAll()
	{
		return (Collection<Formation>) formationService.listFormations();
	}

	/**
	 *
	 * @param codeFormation
	 *            l'id de formation
	 */
	@RequestMapping(value = "/delete/{codeformation}", method = RequestMethod.DELETE)
	public final void deleteFormation(@PathVariable("codeformation") final String codeFormation)
	{
		formationService.deleteFormation(codeFormation);
	}
}
