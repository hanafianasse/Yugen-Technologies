package fr.univbrest.dosi.spi.controller;

import fr.univbrest.dosi.spi.bean.Rubrique;
import fr.univbrest.dosi.spi.bean.RubriqueEvaluation;
import fr.univbrest.dosi.spi.service.RubriqueEvaluationService;
import fr.univbrest.dosi.spi.service.RubriqueService;
import io.swagger.annotations.Api;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Red1
 *
 */
@RestController
@RequestMapping(value = "/rubrique")
@Api(value = "rubrique", description = "Description de la ressource rubrique.")
public class RubriqueController {
	
	@Autowired
	private RubriqueService rubriqueService;
	
	@Autowired
	private RubriqueEvaluationService rubriqueEvaluationService;

	@RequestMapping( method = RequestMethod.POST)
	public final Rubrique addRubrique(@RequestBody  Rubrique rubrique) {
		return rubriqueService.addRubrique(rubrique);
	}
	/**
	 * 
	 * @param rubrique
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
	public final Rubrique editRubrique(@RequestBody final Rubrique rubrique) {
		return rubriqueService.updateRubrique(rubrique);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public final Iterable<Rubrique> GetRubrique() {

		final Iterable<Rubrique> rubriques = rubriqueService.listRubriques();
		return rubriques;
	}
	
	@RequestMapping(value = "/delete/{idRubrique}",method = RequestMethod.DELETE, headers = "Accept=application/json")
	public final void removeRubrique(@PathVariable("idRubrique") final Long id_rubrique) {
		rubriqueService.deleteRubrique(id_rubrique);
	}
	
	@RequestMapping(value = "/{idRubrique}",method = RequestMethod.GET,produces = "application/json")
	public final Rubrique rubrique(@PathVariable(value = "idRubrique") final Long idRubrique) {
		return rubriqueService.getRubrique(idRubrique);
	}
	
	/**
	 * 
	 * @param idEvaluation
	 * @return la liste des rubriques d'une évaluation
	 */
	@RequestMapping(value = "/getRubriqueByIdEvaluation/{idEvaluation}", method = RequestMethod.GET)
	public Set<Rubrique> getRubriqueByIdEvaluation(@PathVariable("idEvaluation") Long idEvaluation)
	{
		Set<Rubrique> rubriques = new HashSet<Rubrique>();
		
		for(RubriqueEvaluation re : rubriqueEvaluationService.getRubriqueEvaluationByIdEvaluation(new BigDecimal(idEvaluation)))
			if(re.getIdRubrique() != null)
				rubriques.add(rubriqueService.getRubrique(re.getIdRubrique().longValue()));
		
		return rubriques;
	}
}

