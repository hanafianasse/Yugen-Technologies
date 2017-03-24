package fr.univbrest.dosi.spi.controller;

import fr.univbrest.dosi.spi.bean.Question;
import fr.univbrest.dosi.spi.bean.QuestionEvaluation;
import fr.univbrest.dosi.spi.service.QuestionEvaluationService;
import fr.univbrest.dosi.spi.service.QuestionService;
import io.swagger.annotations.Api;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/question")
@Api(value = "question", description = "Description de la ressource question.")
public class QuestionController
{

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionEvaluationService questionEvaluationService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Question> getAll()
	{
		return questionService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addQuestion(@RequestBody Question qst)
	{
		questionService.addQuestion(qst);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idQuestion}")
	public void deleteQuestion(@PathVariable("idQuestion") Long idQuestion)
	{
		questionService.deleteQuestion(idQuestion);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Question updateQuestion(@RequestBody Question qst)
	{
		return questionService.UpdateQuestion(qst);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{IdQuestion}")
	public Question getQuestion(@PathVariable("IdQuestion") Long idqst)
	{
		return questionService.getQuestion(idqst);
	}
	
	/**
	 * 
	 * @param idRubriqueEvaluation
	 * @return la liste des questions d'une rubrique d'une évaluation
	 */
	@RequestMapping(value = "/getQuestionByIdRubriqueEvaluation/{idRubriqueEvaluation}", method = RequestMethod.GET)
	public Set<Question> getQuestionByIdRubriqueEvaluation(@PathVariable("idRubriqueEvaluation") Long idRubriqueEvaluation)
	{
		Set<Question> questions = new HashSet<Question>();
		
		for(QuestionEvaluation qe : questionEvaluationService.getQuestionEvaluationByIdRubriqueEvaluation(new BigDecimal(idRubriqueEvaluation)))
			if(qe.getIdQuestion() != null)
				questions.add(questionService.getQuestion(qe.getIdQuestion().longValue()));
		
		return questions;
	}

}
