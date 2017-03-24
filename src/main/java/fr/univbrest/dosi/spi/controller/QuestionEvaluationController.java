/**
 * 
 */
package fr.univbrest.dosi.spi.controller;

import fr.univbrest.dosi.spi.bean.QuestionEvaluation;
import fr.univbrest.dosi.spi.service.QuestionEvaluationService;
import io.swagger.annotations.Api;

import java.math.BigDecimal;
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
@RequestMapping(value = "/questionEvaluation")
@Api(value = "questionEvaluation", description = "Description de la ressource questionEvaluation.")
public class QuestionEvaluationController
{
	@Autowired
	private QuestionEvaluationService questionEvaluationService;

	@RequestMapping(method = RequestMethod.POST)
	public QuestionEvaluation addQuestionEvaluation(
			@RequestBody QuestionEvaluation questionEvaluation)
	{
		return questionEvaluationService
				.addQuestionEvaluation(questionEvaluation);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public QuestionEvaluation updateQuestionEvaluation(
			@RequestBody QuestionEvaluation questionEvaluation)
	{
		return questionEvaluationService
				.updateQuestionEvaluation(questionEvaluation);
	}
	
	@RequestMapping(value = "/{idQuestionEvaluation}", method = RequestMethod.DELETE)
	public void deleteQuestionEvaluation(@PathVariable("idQuestionEvaluation") Long idQuestionEvaluation)
	{
		questionEvaluationService.deleteQuestionEvaluation(idQuestionEvaluation);
	}
	
	@RequestMapping(value = "/{idQuestionEvaluation}", method = RequestMethod.GET)
	public QuestionEvaluation getQuestionEvaluation(@PathVariable("idQuestionEvaluation") Long idQuestionEvaluation)
	{
		return questionEvaluationService.getQuestionEvaluation(idQuestionEvaluation);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<QuestionEvaluation> getAll()
	{
		return (Collection<QuestionEvaluation>) questionEvaluationService.getAll();
	}
	
	@RequestMapping(value = "/getByIdRubriqueEvaluation/{idRubriqueEvaluation}", method = RequestMethod.GET)
	public Collection<QuestionEvaluation> getQuestionEvaluationByIdRubriqueEvaluation(@PathVariable("idRubriqueEvaluation") Long idRubriqueEvaluation)
	{
		return (Collection<QuestionEvaluation>) questionEvaluationService.getQuestionEvaluationByIdRubriqueEvaluation(new BigDecimal(idRubriqueEvaluation));
	}

}
