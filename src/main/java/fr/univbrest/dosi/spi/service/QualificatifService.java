/**
 * 
 */
package fr.univbrest.dosi.spi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Qualificatif;
import fr.univbrest.dosi.spi.dao.QualificatifRepository;
import fr.univbrest.dosi.spi.exception.SPIException;

/**
 * @author Chobaz
 *
 *         9 mars 2017
 */
@Service
public class QualificatifService
{
	@Autowired
	private QualificatifRepository qualificatifRepository;

	@Autowired
	public QualificatifService(QualificatifRepository entrepot)
	{
		this.qualificatifRepository = entrepot;
	}

	public Qualificatif addQualificatif(Qualificatif qualificatif)
	{
		return qualificatifRepository.save(qualificatif);
	}

	public Qualificatif updateQualificatif(Qualificatif qualificatif)
	{
		if (qualificatifRepository.exists(qualificatif.getIdQualificatif()))
			return qualificatifRepository.save(qualificatif);
		else
			throw new SPIException("Qualificatif introuvable !");
	}

	public void deleteQualificatif(long idQualificatif)
	{
		if (qualificatifRepository.exists(idQualificatif))
			qualificatifRepository.delete(qualificatifRepository
					.findOne(idQualificatif));
		else
			throw new SPIException("Qualificatif introuvable !");
	}

	public Qualificatif getQualificatif(long idQualificatif)
	{
		return qualificatifRepository.findOne(idQualificatif);
	}

	public Iterable<Qualificatif> getAll()
	{
		return qualificatifRepository.findAll();
	}

}
