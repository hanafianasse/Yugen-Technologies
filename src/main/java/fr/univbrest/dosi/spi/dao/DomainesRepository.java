package fr.univbrest.dosi.spi.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;


import org.springframework.data.repository.query.Param;

import fr.univbrest.dosi.spi.bean.CgRefCode;

/**
 * 
 * @author Red1
 *
 */
public interface DomainesRepository extends PagingAndSortingRepository <CgRefCode, Long> {
	
	List<CgRefCode> findByRvDomain(@Param("rvDomain") String rvDomain);
	
}
