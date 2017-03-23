package fr.univbrest.dosi.spi.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.univbrest.dosi.spi.bean.ElementConstitutif;
import fr.univbrest.dosi.spi.bean.ElementConstitutifPK;

/**
 * @author DOSI
 *
 */
public interface ElementConstitutifRepository extends PagingAndSortingRepository<ElementConstitutif, ElementConstitutifPK> 
{
	List<ElementConstitutif> findByElementConstitutifPK_CodeUe(String codeUe);
}
