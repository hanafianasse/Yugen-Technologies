package fr.univbrest.dosi.spi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.univbrest.dosi.spi.bean.ReponseQuestion;
import fr.univbrest.dosi.spi.bean.ReponseQuestionPK;



public interface ReponseQuestionRepository extends PagingAndSortingRepository<ReponseQuestion, ReponseQuestionPK> {

}
