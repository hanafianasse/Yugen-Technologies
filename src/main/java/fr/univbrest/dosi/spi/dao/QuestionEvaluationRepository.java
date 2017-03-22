/**
 * 
 */
package fr.univbrest.dosi.spi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.univbrest.dosi.spi.bean.QuestionEvaluation;

/**
 * @author Chobaz
 *
 * 21 mars 2017
 */
public interface QuestionEvaluationRepository extends PagingAndSortingRepository<QuestionEvaluation, Long>
{

}
