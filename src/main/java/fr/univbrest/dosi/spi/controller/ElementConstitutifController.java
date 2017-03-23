/**
 * 
 */
package fr.univbrest.dosi.spi.controller;

import io.swagger.annotations.Api;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.spi.bean.ElementConstitutif;
import fr.univbrest.dosi.spi.bean.ElementConstitutifPK;
import fr.univbrest.dosi.spi.service.ElementConstitutifService;

/**
 * @author Chobaz
 *
 *         23 mars 2017
 */
@RestController
@RequestMapping(value = "/elementConstitutif")
@Api(value = "elementConstitutif", description = "Description de la ressource elementConstitutif.")
public class ElementConstitutifController
{
	@Autowired
	private ElementConstitutifService elementConstitutifService;

	@RequestMapping(method = RequestMethod.POST)
	public ElementConstitutif addElementConstitutif(
			@RequestBody ElementConstitutif elementConstitutif)
	{
		return elementConstitutifService
				.addElementConstitutif(elementConstitutif);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ElementConstitutif updateElementConstitutif(
			@RequestBody ElementConstitutif elementConstitutif)
	{
		return elementConstitutifService
				.updateElementConstitutif(elementConstitutif);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteElementConstitutif(
			@RequestBody ElementConstitutifPK elementConstitutifPK)
	{
		elementConstitutifService
				.deleteElementConstitutif(elementConstitutifPK);
	}

	@RequestMapping(value = "/{codeFormation}/{codeUe}/{codeEc}", method = RequestMethod.GET)
	public ElementConstitutif getElementConstitutif(
			@PathVariable("codeFormation") String codeFormation,
			@PathVariable("codeUe") String codeUe,
			@PathVariable("codeEc") String codeEc)
	{
		ElementConstitutifPK elementConstitutifPK = new ElementConstitutifPK(
				codeFormation, codeUe, codeEc);

		return elementConstitutifService
				.getElementConstitutif(elementConstitutifPK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<ElementConstitutif> getAll()
	{
		return (Collection<ElementConstitutif>) elementConstitutifService
				.getAll();
	}

	@RequestMapping(value = "getByCodeUe/{codeUe}", method = RequestMethod.GET)
	public List<ElementConstitutif> getByCodeUe(
			@PathVariable("codeUe") String codeUe)
	{
		return elementConstitutifService
				.getByElementConstitutifPK_CodeUe(codeUe);
	}

}
