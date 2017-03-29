package fr.univbrest.dosi.spi.controller;

import java.util.List;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.bean.RubriqueQuestion;
import fr.univbrest.dosi.spi.bean.RubriqueQuestionPK;
import fr.univbrest.dosi.spi.service.RubriqueQuestionService;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/rubriqueQuestion")
@Api(value = "rubriqueQuestion", description = "Description de la ressource rubriqueQuestion.")
public class RubriqueQuestionController {

	@Autowired
	private RubriqueQuestionService rubriqueQuestionService;
	
	// Afficher les rubriques question
	@RequestMapping(value = "/{idRubrique}", method = RequestMethod.GET, produces = "application/json")
	public final List<RubriqueQuestion> GetRubQst(@PathVariable(value = "idRubrique") final long idRubrique)		
	{
	return rubriqueQuestionService.getRubriqueQuestions(idRubrique) ;  }
	
	
	
	
}
