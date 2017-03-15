package fr.univbrest.dosi.spi.dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.univbrest.dosi.spi.bean.Rubrique;

/**
 * 
 * @author Red1
 *
 */

@RepositoryRestResource(collectionResourceRel = "rubrique", path = "rubriques")
public interface RubriqueRepository extends PagingAndSortingRepository <Rubrique, Long> {

	

}
