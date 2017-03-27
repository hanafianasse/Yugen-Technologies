package fr.univbrest.dosi.spi.controller;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



	@RestController
	@RequestMapping(value = "/reponseEvaluation")
	@Api(value = "reponseEvaluation", description = "Description de la ressource reponseEvaluation.")

	public class ReponseEvaluationController {
		
		/*
		@Autowired
		private ReponseQuestionService reponseQuestionService;
		

		@RequestMapping( method = RequestMethod.POST)
		public final Rubrique addRubrique(@RequestBody  ReponseEvaluation reponseEvaluation) {
			return reponseQuestionService.addReponseEvluation(reponseEvaluation);
		}
*/
}
