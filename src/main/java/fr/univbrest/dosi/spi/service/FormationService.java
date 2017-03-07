package fr.univbrest.dosi.spi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Formation;
import fr.univbrest.dosi.spi.dao.FormationRepository;

/**
 * @author DOSI
 *
 */
@Service
public class FormationService {

	@Autowired
	private FormationRepository formationRepository;

	public final Formation addFormation(final Formation formation) {
		return formationRepository.save(formation);
	}

	public final void deleteFormation(final String codeFormation) {
		formationRepository.delete(codeFormation);
	}

	public final Boolean existeFormation(final String code) {
		return formationRepository.exists(code);
	}

	public final Formation getFormation(final String code) {
		return formationRepository.findOne(code);
	}

	public final Iterable<Formation> listFormations() {
		final Iterable<Formation> formations = formationRepository.findAll();
		return formations;
	}

	public final Formation updateFormation(final Formation formation) {

		return formationRepository.save(formation);

	}

}
