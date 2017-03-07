package fr.univbrest.dosi.spi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.univbrest.dosi.spi.bean.Formation;

/**
 * @author DOSI
 *
 */
@RepositoryRestResource(collectionResourceRel = "formation", path = "formation")
public interface FormationRepository extends PagingAndSortingRepository<Formation, String> {

}
