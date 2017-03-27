package fr.univbrest.dosi.spi.controller;

import java.util.Collection;
import java.util.List;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.bean.ReponseQuestion;
import fr.univbrest.dosi.spi.bean.ReponseQuestionPK;
import fr.univbrest.dosi.spi.bean.Rubrique;
import fr.univbrest.dosi.spi.bean.UniteEnseignement;
import fr.univbrest.dosi.spi.bean.UniteEnseignementPK;
import fr.univbrest.dosi.spi.service.ReponseQuestionService;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author Red1
 *
 */
@RestController
@RequestMapping(value = "/reponseQuestion")
@Api(value = "reponseQuestion", description = "Description de la ressource reponseQuestion.")

public class ReponseQuestionController {
	
	
	@Autowired
	private ReponseQuestionService reponseQuestionService;
	

	@RequestMapping(value = "/addReponseQuestion",method = RequestMethod.POST)
	public final ReponseQuestion addReponseQuestion(@RequestBody  ReponseQuestion reponseQuestion) {
		return reponseQuestionService.addReponseQuestion(reponseQuestion);
	}
	
	

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public final Iterable<ReponseQuestion> GetAllReponseQuestions() {

		final Collection<ReponseQuestion> reponses = (Collection<ReponseQuestion>) reponseQuestionService.getAllReponseQuestion();
		return reponses;
	}
	
	
	@RequestMapping(value = "/deleteReponseQuestion",method = RequestMethod.DELETE)
	public void deleteReponseQuestion(
			@RequestBody ReponseQuestionPK reponseQuestionPK)
	{
		reponseQuestionService.deleteReponseQuestion(reponseQuestionPK);
	}
	
	@RequestMapping(value = "/updateReponseQuestion",method = RequestMethod.PUT)
	public ReponseQuestion updateReponseQuestion(
			@RequestBody ReponseQuestion reponseQuestion)
	{
		return reponseQuestionService
				.updateReponseQuestion(reponseQuestion);
	}
	
	/**
	 * 
	 * @param reponseQuestionPK
	 * @return Reponse 
	 */
	
	@RequestMapping(value = "/{idReponseEvaluation}/{idQuestionEvaluation}", method = RequestMethod.GET, produces = "application/json")
	public final ReponseQuestion GetReponseQuestion(
			@PathVariable(value = "idReponseEvaluation") final long idReponseEvaluation,
			@PathVariable(value = "idQuestionEvaluation") final long idQuestionEvaluation)
	{
		ReponseQuestionPK reponseQuestionPk = new ReponseQuestionPK(idReponseEvaluation,idQuestionEvaluation);
		return  reponseQuestionService.getReponseQuestion(reponseQuestionPk);
	}
	
	
}
