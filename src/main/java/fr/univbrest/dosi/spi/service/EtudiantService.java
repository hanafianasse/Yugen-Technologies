package fr.univbrest.dosi.spi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.dao.EtudiantRepository;

/**
 * @author DOSI
 *
 */
@Service
public class EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;

	public final void addEtudiant(final Etudiant etudiant) {
		etudiantRepository.save(etudiant);
	}

	public final void deletEtudiant(final String noEtudiant) {
		etudiantRepository.delete(noEtudiant);
	}

	public final Boolean existEtudiant(final String noEtudiant) {
		return etudiantRepository.exists(noEtudiant);
	}

	public final Etudiant getEtudiant(final String noEtudiant) {
		return etudiantRepository.findOne(noEtudiant);
	}
}
