/**
 * 
 */
package fr.univbrest.dosi.spi.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.univbrest.dosi.spi.bean.RubriqueQuestion;
import fr.univbrest.dosi.spi.bean.RubriqueQuestionPK;

/**
 * @author Chobaz
 *
 * 9 mars 2017
 */
public interface RubriqueQuestionRepository extends PagingAndSortingRepository<RubriqueQuestion, RubriqueQuestionPK>
{
	List<RubriqueQuestion> findById_IdRubrique(long IdRubrique);

}
