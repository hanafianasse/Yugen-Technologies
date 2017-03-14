package fr.univbrest.dosi.spi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.univbrest.dosi.spi.bean.Rubrique;
import fr.univbrest.dosi.spi.dao.RubriqueRepository;
/**
 * 
 * @author Red1
 * @service de rubrique
 *
 */

@Service
public class RubriqueService  {

	@Autowired
	private RubriqueRepository rubriqueRepository;

	public final Rubrique addRubrique(final Rubrique rubrique) {
		return rubriqueRepository.save(rubrique);
	}

	public final void deleteRubrique(final Long ID_RUBRIQUE) {
		rubriqueRepository.delete(ID_RUBRIQUE);
	}

	public final Iterable<Rubrique> listRubriques() {
		final Iterable<Rubrique> rubriques = rubriqueRepository.findAll();
		return rubriques;
	}

	public final Rubrique updateRubrique(final Rubrique rubrique) {
		return rubriqueRepository.save(rubrique);

	}

}
