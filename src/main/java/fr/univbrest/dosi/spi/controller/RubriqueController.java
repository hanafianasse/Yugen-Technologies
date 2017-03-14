package fr.univbrest.dosi.spi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
public class RubriqueController {
	
	@Autowired
	private RubriqueService rubriqueService;

	@RequestMapping( method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public final Rubrique addRubrique(@RequestBody final Rubrique rubrique) {
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

	

	
	@RequestMapping(produces = "application/json")
	public final Iterable<Rubrique> GetRubriqueall() {
		final Iterable<Rubrique> rubriques = rubriqueService.listRubriques();
		return rubriques;
	}

	
	
	@RequestMapping(value = "/delete/{idRubrique}",method = RequestMethod.DELETE, headers = "Accept=application/json")
	public final void removeRubrique(@PathVariable("idRubrique") final Long id_rubrique) {
		rubriqueService.deleteRubrique(id_rubrique);
	}
}

