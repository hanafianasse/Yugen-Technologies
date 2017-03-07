package fr.univbrest.dosi.spi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.univbrest.dosi.spi.bean.Etudiant;

/**
 * @author DOSI
 *
 */
@RepositoryRestResource(collectionResourceRel = "etudiant", path = "etudiant")
public interface EtudiantRepository extends PagingAndSortingRepository<Etudiant, String> {

}
