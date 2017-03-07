package fr.univbrest.dosi.spi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.spi.bean.Formation;
import fr.univbrest.dosi.spi.service.FormationService;

/**
 * @author DOSI
 *
 */
@RestController
public class FormationController {
	/**
	 *
	 */
	@Autowired
	private FormationService formationService;

	/**
	 *
	 * @param formation
	 *            l'entité de formation
	 * @return une formation
	 */
	@RequestMapping(value = "/formation/ajouterformation", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public final Formation ajouterFormation(@RequestBody final Formation formation) {
		return formationService.addFormation(formation);
	}

	/**
	 *
	 * @param formation
	 *            l'entité de formation
	 * @return une formation
	 */
	@RequestMapping(value = "/formation/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public final Formation editFormation(@RequestBody final Formation formation) {
		return formationService.updateFormation(formation);
	}

	/**
	 *
	 * @param codeFormation
	 *            l'id de formation
	 * @return une formation
	 */
	@RequestMapping(value = "/formation/{codeFormation}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public final Formation formation(@PathVariable(value = "codeFormation") final String codeFormation) {
		return formationService.getFormation(codeFormation);

	}

	/*
	 * @RequestMapping(value = "/formations", produces = { MediaType.APPLICATION_JSON_VALUE }) public Iterable<Formation> getAll(){ return formationService.listFormations(); }
	 */
	/**
	 *
	 * @return list de formation
	 */
	@RequestMapping(produces = "application/json", value = "/formations")
	public final Iterable<Formation> formations() {

		// enseignantService.traitement();
		final Iterable<Formation> formations = formationService.listFormations();
		for (final Formation frm : formations) {
			System.out.println("OK traitement " + frm.getNomFormation());
		}
		return formationService.listFormations();

	}

	/*
	 * @RequestMapping(produces = "application/json",value ="/getformation/{code}") public Formation getFormation(@PathVariable(value="codeFormation") final String codeFormation) { return
	 * formationService.getFormation(codeFormation); }
	 */
	/**
	 *
	 * @param codeFormation
	 *            l'id de formation
	 */
	@RequestMapping(value = "/formation/delete/{codeformation}", headers = "Accept=application/json")
	public final void removeFormation(@PathVariable("codeformation") final String codeFormation) {
		formationService.deleteFormation(codeFormation);
	}
}
