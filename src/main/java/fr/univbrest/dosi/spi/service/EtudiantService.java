package fr.univbrest.dosi.spi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.dao.EtudiantRepository;
import fr.univbrest.dosi.spi.exception.SPIException;

/**
 * @author DOSI
 *
 */
@Service
public class EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	public EtudiantService(EtudiantRepository entrepot) {
		this.etudiantRepository = entrepot;
	}

	public final Etudiant addEtudiant(final Etudiant etudiant) {

		return etudiantRepository.save(etudiant);
	}

	public final void deleteEtudiant(final String noEtudiant) {
		etudiantRepository.delete(noEtudiant);
	}

	public final Boolean existEtudiant(final String noEtudiant) {
		return etudiantRepository.exists(noEtudiant);
	}

	public final Etudiant getEtudiant(final String noEtudiant) {
		return etudiantRepository.findOne(noEtudiant);
	}

	public final List<Etudiant> getAll() {

		return (List<Etudiant>) etudiantRepository.findAll();
	}

	public final Etudiant updateEtudiant(final Etudiant etudiant, final String oldNoEtudiant) {
		if (etudiant.getNoEtudiant().equals(oldNoEtudiant)) {
			return etudiantRepository.save(etudiant);
		} else {
			if (getEtudiant(etudiant.getNoEtudiant()) == null) {
				System.out.println("je suis la ");
				deleteEtudiant(oldNoEtudiant);
				return etudiantRepository.save(etudiant);
			}
			throw new SPIException("Error : noEtudiant existe d�j� ");
		}
	}

	public final List<Etudiant> getEtudiantByPromotion(Promotion promotion) {
		return (List<Etudiant>) etudiantRepository.findAll();

	}

	public int nombreEtudiants() {
		List<Etudiant> listEtudiants = (List<Etudiant>) etudiantRepository
				.findAll();
		return listEtudiants.size();
	}
	public Promotion getPromotionEtudiant(String noEtudiant){
		Promotion promotionEtudiant=etudiantRepository.findOne(noEtudiant).getPromotion();
		return promotionEtudiant;
	}
}
