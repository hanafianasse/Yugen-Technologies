package fr.univbrest.dosi.spi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.UniteEnseignement;
import fr.univbrest.dosi.spi.bean.UniteEnseignementPK;
import fr.univbrest.dosi.spi.dao.UniteEnseignementRepository;
import fr.univbrest.dosi.spi.exception.SPIException;

/**
 * @author DOSI
 *
 */
@Service
public class UniteEnseignementService
{
	private UniteEnseignementRepository uniteEnseignementRepository;

	@Autowired
	public UniteEnseignementService(UniteEnseignementRepository entrepot)
	{
		this.uniteEnseignementRepository = entrepot;
	}

	public UniteEnseignement addUniteEnseignement(
			UniteEnseignement uniteEnseignement)
	{
		return uniteEnseignementRepository.save(uniteEnseignement);
	}

	public UniteEnseignement updateUniteEnseignement(
			UniteEnseignement uniteEnseignement)
	{
		// Vérification que l'uniteEnseignement à modifier existe
		if (uniteEnseignementRepository.exists(uniteEnseignement
				.getUniteEnseignementPK()))
			return uniteEnseignementRepository.save(uniteEnseignement);
		else
			throw new SPIException("UniteEnseignement introuvable !");
	}

	public void deleteUniteEnseignement(UniteEnseignementPK uniteEnseignementPK)
	{
		// Vérification que l'uniteEnseignement à supprimer existe
		if (uniteEnseignementRepository.exists(uniteEnseignementPK))
			uniteEnseignementRepository.delete(uniteEnseignementRepository
					.findOne(uniteEnseignementPK));
		else
			throw new SPIException("UniteEnseignement introuvable !");
	}

	public UniteEnseignement getUniteEnseignement(
			UniteEnseignementPK uniteEnseignementPK)
	{
		return uniteEnseignementRepository.findOne(uniteEnseignementPK);
	}

	public Iterable<UniteEnseignement> getAll()
	{
		return uniteEnseignementRepository.findAll();
	}

	// Liste des UE d'une formation
	public List<UniteEnseignement> getByUniteEnseignementPK_CodeFormation(String codeFormation)
	{
		return uniteEnseignementRepository.findByUniteEnseignementPK_CodeFormation(codeFormation);
	}
}
