package fr.univbrest.dosi.spi.dao;

import java.math.BigDecimal;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import fr.univbrest.dosi.spi.bean.Authentification;

public interface AuthentificationRepository extends PagingAndSortingRepository<Authentification,Long>{
	Authentification findByNoEtudiant(@Param("noEtudiant") String noEtudiant);
	Authentification findByNoEnseignant(BigDecimal noEnseignant);
}
