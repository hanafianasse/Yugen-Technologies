package fr.univbrest.dosi.spi.controller;


import fr.univbrest.dosi.spi.bean.ReponseEvaluation;
import fr.univbrest.dosi.spi.service.ReponseEvaluationService;
import io.swagger.annotations.Api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



	@RestController
	@RequestMapping(value = "/reponseEvaluation")
	@Api(value = "reponseEvaluation", description = "Description de la ressource reponseEvaluation.")

	public class ReponseEvaluationController {
		
		@Autowired
		private ReponseEvaluationService ReponseEvaluationService;

		@RequestMapping( method = RequestMethod.POST)
		public final ReponseEvaluation addReponseEvaluation(@RequestBody  ReponseEvaluation reponseEvaluation) {
			return ReponseEvaluationService.addReponseEvaluation(reponseEvaluation);
		}
		
		
		
		@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
		public final ReponseEvaluation editReponseEvaluation(@RequestBody final ReponseEvaluation reponseEvaluation) {
			return ReponseEvaluationService.updateReponseEvaluation(reponseEvaluation);
		}
		

		@RequestMapping(method = RequestMethod.GET, produces = "application/json")
		public final Iterable<ReponseEvaluation> getReponseEvaluation() {

			final Iterable<ReponseEvaluation> reponseEvaluations = ReponseEvaluationService.getAllReponseEvaluation();
			return reponseEvaluations;
		}
		
		
		
		@RequestMapping(value = "/delete/{idReponseEvaluation}",method = RequestMethod.DELETE, headers = "Accept=application/json")
		public final void removeReponseEvaluation(@PathVariable("idReponseEvaluation") final Long idReponseEvaluation) {
			ReponseEvaluationService.deleteReponseEvaluation(idReponseEvaluation);
		}
		
		
		
		@RequestMapping(value = "/{idReponseEvaluation}",method = RequestMethod.GET,produces = "application/json")
		public final ReponseEvaluation reponseEvaluation(@PathVariable(value = "idReponseEvaluation") final Long idReponseEvaluation) {
			return ReponseEvaluationService.getReponseEvaluation(idReponseEvaluation);
		}
		
		
		@RequestMapping(value = "/getReponseEvaluationByIdEvaluationNoEtudiant/{idEvaluation}/{noEtudiant}",method = RequestMethod.GET,produces = "application/json")
		public final ReponseEvaluation getReponseEvaluationByIdEvaluationNoEtudiant(@PathVariable(value = "idEvaluation") final Long idEvaluation, @PathVariable(value = "noEtudiant") final String noEtudiant) {
			return ((List<ReponseEvaluation>) ReponseEvaluationService.getAllReponseEvaluation()).stream().filter((ReponseEvaluation re) -> re.getIdEvaluation().longValue() == idEvaluation && re.getNoEtudiant().equals(noEtudiant)).findAny().get();
		}
		
}
