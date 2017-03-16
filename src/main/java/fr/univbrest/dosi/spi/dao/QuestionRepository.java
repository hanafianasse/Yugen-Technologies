package fr.univbrest.dosi.spi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.univbrest.dosi.spi.bean.Question;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {

}
