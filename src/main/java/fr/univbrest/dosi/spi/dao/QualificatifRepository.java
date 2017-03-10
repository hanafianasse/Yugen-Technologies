/**
 * 
 */
package fr.univbrest.dosi.spi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.univbrest.dosi.spi.bean.Qualificatif;

/**
 * @author Chobaz
 *
 * 9 mars 2017
 */
public interface QualificatifRepository extends PagingAndSortingRepository<Qualificatif, Long>
{

}
