package fr.univbrest.dosi.spi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.ElementConstitutif;
import fr.univbrest.dosi.spi.bean.ElementConstitutifPK;
import fr.univbrest.dosi.spi.dao.ElementConstitutifRepository;

/**
 * @author DOSI
 *
 */
@Service
public class ElementConstitutifService {

	@Autowired
	private ElementConstitutifRepository elementConstitutifRepository;

	public final void addElementConstitutif(final ElementConstitutif elementConstitutif) {
		elementConstitutifRepository.save(elementConstitutif);
	}

	public final void deleteElementConstitutif(final ElementConstitutifPK elementConstitutifPK) {
		elementConstitutifRepository.delete(elementConstitutifPK);
	}

	public final Boolean existElementCostitutif(final ElementConstitutifPK elementConstitutifPK) {
		return elementConstitutifRepository.exists(elementConstitutifPK);
	}

	public final ElementConstitutif getElementConstitutif(final ElementConstitutifPK elementConstitutifPK) {
		return elementConstitutifRepository.findOne(elementConstitutifPK);
	}

}
