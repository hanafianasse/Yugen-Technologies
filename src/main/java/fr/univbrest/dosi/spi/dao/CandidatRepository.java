package fr.univbrest.dosi.spi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.univbrest.dosi.spi.bean.Candidat;

/**
 * @author DOSI
 *
 */
@RepositoryRestResource(collectionResourceRel = "candidat", path = "candidat")
public interface CandidatRepository extends PagingAndSortingRepository<Candidat, String> {

}
