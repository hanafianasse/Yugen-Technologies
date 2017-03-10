package fr.univbrest.dosi.spi.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Authentification;
import fr.univbrest.dosi.spi.dao.AuthentificationRepository;

@Service
public class AuthentificationService {

	@Autowired
	private AuthentificationRepository authentificationReposity;

	public Authentification addAuthentification(
			final Authentification authentification) {
		return authentificationReposity.save(authentification);
	}

	public List<Authentification> getAll() {
		return (List<Authentification>) authentificationReposity.findAll();
	}

	public Authentification getAuthentification(final long idConnection) {
		return authentificationReposity.findOne(idConnection);
	}
	
	public Authentification getAuthentificationByNoEtudiant(final String noEtudiant) {
		return authentificationReposity.findByNoEtudiant(noEtudiant);
	}
	
	public Authentification getAuthentificationByNoEnseignant(final BigDecimal noEnseignant) {
		return authentificationReposity.findByNoEnseignant(noEnseignant);
	}

	public void deleteAuthentification(final long idConnection) {
		authentificationReposity.delete(idConnection);
	}

	public Authentification updateAuthentification(
			final Authentification authentification) {
		return authentificationReposity.save(authentification);
	}

}
