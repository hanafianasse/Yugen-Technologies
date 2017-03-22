/**
 * 
 */
package fr.univbrest.dosi.spi.controller;

import fr.univbrest.dosi.spi.bean.RubriqueEvaluation;
import fr.univbrest.dosi.spi.service.RubriqueEvaluationService;
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
 *         21 mars 2017
 */
@RestController
@RequestMapping(value = "/rubriqueEvaluation")
@Api(value = "rubriqueEvaluation", description = "Description de la ressource rubriqueEvaluation.")
public class RubriqueEvaluationController
{
	@Autowired
	private RubriqueEvaluationService rubriqueEvaluationService;

	@RequestMapping(method = RequestMethod.POST)
	public RubriqueEvaluation addRubriqueEvaluation(
			@RequestBody RubriqueEvaluation rubriqueEvaluation)
	{
		return rubriqueEvaluationService
				.addRubriqueEvaluation(rubriqueEvaluation);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public RubriqueEvaluation updateRubriqueEvaluation(
			@RequestBody RubriqueEvaluation rubriqueEvaluation)
	{
		return rubriqueEvaluationService
				.updateRubriqueEvaluation(rubriqueEvaluation);
	}
	
	@RequestMapping(value = "/{idRubriqueEvaluation}", method = RequestMethod.DELETE)
	public void deleteRubriqueEvaluation(@PathVariable("idRubriqueEvaluation") Long idRubriqueEvaluation)
	{
		rubriqueEvaluationService.deleteRubriqueEvaluation(idRubriqueEvaluation);
	}
	
	@RequestMapping(value = "/{idRubriqueEvaluation}", method = RequestMethod.GET)
	public RubriqueEvaluation getRubriqueEvaluation(@PathVariable("idRubriqueEvaluation") Long idRubriqueEvaluation)
	{
		return rubriqueEvaluationService.getRubriqueEvaluation(idRubriqueEvaluation);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<RubriqueEvaluation> getAll()
	{
		return (Collection<RubriqueEvaluation>) rubriqueEvaluationService.getAll();
	}

}
