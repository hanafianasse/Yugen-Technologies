/**
 * 
 */
package fr.univbrest.dosi.spi.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.univbrest.dosi.spi.bean.RubriqueEvaluation;

/**
 * @author Chobaz
 *
 * 21 mars 2017
 */
public interface RubriqueEvaluationRepository  extends PagingAndSortingRepository<RubriqueEvaluation, Long>
{
	List<RubriqueEvaluation> findByIdEvaluation(BigDecimal idEvaluation);
}
