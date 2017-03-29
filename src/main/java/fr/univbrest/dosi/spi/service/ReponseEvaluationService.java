package fr.univbrest.dosi.spi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.ReponseEvaluation;

import fr.univbrest.dosi.spi.dao.ReponseEvaluationRepository;

/**
 * 
 * @author Red1
 *
 */

@Service
public class ReponseEvaluationService {
	
	@Autowired
	ReponseEvaluationRepository ReponseEvaluationRepository;
	
 public ReponseEvaluation	addReponseEvaluation (ReponseEvaluation ReponseEvaluation){
	return ReponseEvaluationRepository.save(ReponseEvaluation);
	 
 }
 

 public final Iterable<ReponseEvaluation> getAllReponseEvaluation() {
		final Iterable<ReponseEvaluation> reponses = ReponseEvaluationRepository.findAll();
		return reponses;
	}
 
 
 
 public void deleteReponseEvaluation(long idReponseEvaluation)
	{
			ReponseEvaluationRepository.delete(idReponseEvaluation);
	}
 
 
 public ReponseEvaluation updateReponseEvaluation(ReponseEvaluation ReponseEvaluation)
	{
	 return ReponseEvaluationRepository.save(ReponseEvaluation);
	}
 
 	
 public ReponseEvaluation getReponseEvaluation(long idReponseEvaluation ){

		return ReponseEvaluationRepository.findOne(idReponseEvaluation);
 		}
 
	}
 	

