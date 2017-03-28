package fr.univbrest.dosi.spi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.ReponseQuestion;
import fr.univbrest.dosi.spi.bean.ReponseQuestionPK;
import fr.univbrest.dosi.spi.dao.ReponseQuestionRepository;
import fr.univbrest.dosi.spi.exception.SPIException;
/**
 * 
 * @author Red1
 *
 */

@Service
public class ReponseQuestionService {
	
	@Autowired
	ReponseQuestionRepository reponseQuestionRepository;
	
 public ReponseQuestion	addReponseQuestion (ReponseQuestion reponseQuestion){
	return reponseQuestionRepository.save(reponseQuestion);
	 
 }
 

 public final Iterable<ReponseQuestion> getAllReponseQuestion() {
		final Iterable<ReponseQuestion> reponses = reponseQuestionRepository.findAll();
		return reponses;
	}
 
 
 
 public void deleteReponseQuestion(ReponseQuestionPK reponseQuestionPK)
	{
		
		if (reponseQuestionRepository.exists(reponseQuestionPK))
			reponseQuestionRepository.delete(reponseQuestionRepository.findOne(reponseQuestionPK));
		else
			throw new SPIException("ReponseQuestion introuvable !");
	}
 
 
 public ReponseQuestion updateReponseQuestion(ReponseQuestion reponseQuestion)
	{
	 if (reponseQuestionRepository.exists(reponseQuestion.getId()))
			return reponseQuestionRepository.save(reponseQuestion);
		else
			throw new SPIException("ReponseQuestion introuvable !");
	}
 	
 public ReponseQuestion getReponseQuestion(
		 ReponseQuestionPK reponseQuestionPK)
	{
		return reponseQuestionRepository.findOne(reponseQuestionPK);
	}
 	

}
