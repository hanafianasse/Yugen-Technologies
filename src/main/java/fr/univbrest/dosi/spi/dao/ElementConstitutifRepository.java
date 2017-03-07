package fr.univbrest.dosi.spi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.univbrest.dosi.spi.bean.ElementConstitutif;
import fr.univbrest.dosi.spi.bean.ElementConstitutifPK;

/**
 * @author DOSI
 *
 */
@RepositoryRestResource(collectionResourceRel = "elementConstitutif", path = "elementConstitutif")
public interface ElementConstitutifRepository extends PagingAndSortingRepository<ElementConstitutif, ElementConstitutifPK> {

}
