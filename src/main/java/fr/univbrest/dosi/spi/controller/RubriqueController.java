package fr.univbrest.dosi.spi.controller;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





import fr.univbrest.dosi.spi.bean.Rubrique;
import fr.univbrest.dosi.spi.service.RubriqueService;

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

	
	@RequestMapping(value = "/delete/{id_rubrique}",method = RequestMethod.DELETE, headers = "Accept=application/json")
	public final void removeRubrique(@PathVariable("id_rubrique") final Long id_rubrique) {
		rubriqueService.deleteRubrique(id_rubrique);
	}
	
	@RequestMapping(value = "/{idRubrique}",method = RequestMethod.GET,produces = "application/json")
	public final Rubrique rubrique(@PathVariable(value = "idRubrique") final Long idRubrique) {
		return rubriqueService.getRubrique(idRubrique);
	}
}

