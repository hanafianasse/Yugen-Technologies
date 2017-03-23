/**
 * 
 */
package fr.univbrest.dosi.spi.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.univbrest.dosi.spi.bean.QuestionEvaluation;

/**
 * @author Chobaz
 *
 * 21 mars 2017
 */
public interface QuestionEvaluationRepository extends PagingAndSortingRepository<QuestionEvaluation, Long>
{
	List<QuestionEvaluation> findByIdRubriqueEvaluation(BigDecimal idRubriqueEvaluation);
}
