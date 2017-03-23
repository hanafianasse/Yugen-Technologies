package fr.univbrest.dosi.spi.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import fr.univbrest.dosi.spi.bean.UniteEnseignement;
import fr.univbrest.dosi.spi.bean.UniteEnseignementPK;

/**
 * @author DOSI
 *
 */
public interface UniteEnseignementRepository extends PagingAndSortingRepository<UniteEnseignement, UniteEnseignementPK> {
	/**
	 *
	 * @param noEnseignant
	 *            l'id de l'enseignant
	 * @return liste des unite enseignement
	 */
	List<UniteEnseignement> findByNoEnseignant(@Param("noEnseignant") Integer noEnseignant); //?????????
	List<UniteEnseignement> findByUniteEnseignementPK_CodeFormation(String codeFormation);
}
