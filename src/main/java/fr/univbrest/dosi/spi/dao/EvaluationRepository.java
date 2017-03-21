package fr.univbrest.dosi.spi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.univbrest.dosi.spi.bean.Evaluation;


public interface EvaluationRepository  extends PagingAndSortingRepository <Evaluation, Long>{
	

}
