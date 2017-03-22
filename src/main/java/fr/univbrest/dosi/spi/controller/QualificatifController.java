/**
 * 
 */
package fr.univbrest.dosi.spi.controller;

import fr.univbrest.dosi.spi.bean.Qualificatif;
import fr.univbrest.dosi.spi.service.QualificatifService;
import io.swagger.annotations.Api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chobaz
 *
 *         9 mars 2017
 */
@RestController
@RequestMapping(value = "/qualificatif")
@Api(value = "qualificatif", description = "Description de la ressource qualificatif.")
public class QualificatifController
{
	@Autowired
	private QualificatifService qualificatifService;

	@RequestMapping(method = RequestMethod.POST)
	public Qualificatif addQualificatif(@RequestBody Qualificatif qualificatif)
	{
		return qualificatifService.addQualificatif(qualificatif);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Qualificatif updateQualificatif(
			@RequestBody Qualificatif qualificatif)
	{
		return qualificatifService.updateQualificatif(qualificatif);
	}

	@RequestMapping(value = "/{idQualificatif}", method = RequestMethod.DELETE)
	public void deleteQualificatif(
			@PathVariable("idQualificatif") Long idQualificatif)
	{
		qualificatifService.deleteQualificatif(idQualificatif);
	}

	@RequestMapping(value = "/{idQualificatif}", method = RequestMethod.GET)
	public Qualificatif getQualificatif(
			@PathVariable("idQualificatif") Long idQualificatif)
	{
		return qualificatifService.getQualificatif(idQualificatif);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Qualificatif> getAll()
	{
		return (Collection<Qualificatif>) qualificatifService.getAll();
	}

}
