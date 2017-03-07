package fr.univbrest.dosi.spi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Candidat;
import fr.univbrest.dosi.spi.dao.CandidatRepository;

/**
 * @author DOSI
 *
 */
@Service
public class CandidatService {

	@Autowired
	private CandidatRepository candidatRepository;

	public void addCandidat(final Candidat candidat) {
		candidatRepository.save(candidat);
	}

	public void deleteCandidat(final String noCandidat) {
		candidatRepository.delete(noCandidat);
	}

	public Boolean existeCandidat(final String noCandidat) {
		return candidatRepository.exists(noCandidat);
	}

	public Candidat getCandidat(final String noCandidat) {
		return candidatRepository.findOne(noCandidat);
	}

}
