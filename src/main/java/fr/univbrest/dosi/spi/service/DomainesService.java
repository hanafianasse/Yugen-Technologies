package fr.univbrest.dosi.spi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.CgRefCode;
import fr.univbrest.dosi.spi.dao.DomainesRepository;

/**
 * 
 * @author Red1
 *
 */
@Service
public class DomainesService {

	@Autowired
	DomainesRepository domainesRepository;
/*
	public final CgRefCode getDomainById(final long idCgrc) {
		return domainesRepository.findByIdCgrc(idCgrc);
	}
	*/
	// Methode pour recuper les domaines 
	
	public final List<CgRefCode> getDomainByRvDomain(final String rvDomain) {
		List<CgRefCode> domaines =domainesRepository.findByRvDomain(rvDomain);
		return domaines;
	}
	
}
