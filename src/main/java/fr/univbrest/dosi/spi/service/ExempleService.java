package fr.univbrest.dosi.spi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Enseignant;
import fr.univbrest.dosi.spi.dao.EnseignantRepository;

/**
 * @author DOSI
 *
 */
@Service
public class ExempleService {

	@Autowired
	private EnseignantRepository enseignantRepository;

	public final Iterable<Enseignant> listens() {
		final Iterable<Enseignant> enseignants = enseignantRepository.findAll();
		for (final Enseignant ens : enseignants) {
			System.out.println("OK traitement " + ens.getNom());
		}
		System.out.println("OK traitement");
		return enseignants;
	}

	public final void traitement() {
		final Iterable<Enseignant> enseignants = enseignantRepository.findAll();
		for (final Enseignant ens : enseignants) {
			System.out.println("OK traitement " + ens.getNom());
		}
		// System.out.println("OK traitement");
	}
}
