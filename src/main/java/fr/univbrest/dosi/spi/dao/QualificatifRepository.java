/**
 * 
 */
package fr.univbrest.dosi.spi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.univbrest.dosi.spi.bean.Qualificatif;

/**
 * @author Chobaz
 *
 * 9 mars 2017
 */
@RepositoryRestResource(collectionResourceRel = "qualificatif", path = "qualificatif")
public interface QualificatifRepository extends PagingAndSortingRepository<Qualificatif, Long>
{
	
}
