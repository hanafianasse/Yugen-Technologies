package fr.univbrest.dosi.spi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.ElementConstitutif;
import fr.univbrest.dosi.spi.bean.ElementConstitutifPK;
import fr.univbrest.dosi.spi.bean.ElementConstitutif;
import fr.univbrest.dosi.spi.bean.ElementConstitutifPK;
import fr.univbrest.dosi.spi.dao.ElementConstitutifRepository;
import fr.univbrest.dosi.spi.dao.ElementConstitutifRepository;
import fr.univbrest.dosi.spi.exception.SPIException;

/**
 * @author DOSI
 *
 */
@Service
public class ElementConstitutifService 
{
	private ElementConstitutifRepository elementConstitutifRepository;

	@Autowired
	public ElementConstitutifService(ElementConstitutifRepository entrepot)
	{
		this.elementConstitutifRepository = entrepot;
	}

	public ElementConstitutif addElementConstitutif(
			ElementConstitutif elementConstitutif)
	{
		return elementConstitutifRepository.save(elementConstitutif);
	}

	public ElementConstitutif updateElementConstitutif(
			ElementConstitutif elementConstitutif)
	{
		// Vérification que l'elementConstitutif à modifier existe
		if (elementConstitutifRepository.exists(elementConstitutif
				.getElementConstitutifPK()))
			return elementConstitutifRepository.save(elementConstitutif);
		else
			throw new SPIException("ElementConstitutif introuvable !");
	}

	public void deleteElementConstitutif(ElementConstitutifPK elementConstitutifPK)
	{
		// Vérification que l'elementConstitutif à supprimer existe
		if (elementConstitutifRepository.exists(elementConstitutifPK))
			elementConstitutifRepository.delete(elementConstitutifRepository
					.findOne(elementConstitutifPK));
		else
			throw new SPIException("ElementConstitutif introuvable !");
	}

	public ElementConstitutif getElementConstitutif(
			ElementConstitutifPK elementConstitutifPK)
	{
		return elementConstitutifRepository.findOne(elementConstitutifPK);
	}

	public Iterable<ElementConstitutif> getAll()
	{
		return elementConstitutifRepository.findAll();
	}

	// Liste des EC d'une UE
	public List<ElementConstitutif> getByElementConstitutifPK_CodeUe(String codeUe)
	{
		return elementConstitutifRepository.findByElementConstitutifPK_CodeUe(codeUe);
	}
}
