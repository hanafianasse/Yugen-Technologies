package fr.univbrest.dosi.spi.controller;

import fr.univbrest.dosi.spi.bean.Evaluation;
import fr.univbrest.dosi.spi.bean.Rubrique;
import fr.univbrest.dosi.spi.service.EvaluationService;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/evaluation")
@Api(value = "evaluation", description = "Description de la ressource evaluation.")

public class EvaluationController {
	
	
	@Autowired
	private EvaluationService evaluationService;
	@RequestMapping(value = "/{idEvaluation}",method = RequestMethod.GET,produces = "application/json")
	public final Evaluation evaluation(@PathVariable(value = "idEvaluation") final Long idEvaluation) {
		return evaluationService.getEvaluation(idEvaluation);
	}
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public final Iterable<Evaluation> GetEvaluation() {

		final Iterable<Evaluation> evaluations = evaluationService.listEvaluations();
		return evaluations;
	}

}
