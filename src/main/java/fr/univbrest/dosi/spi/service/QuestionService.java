package fr.univbrest.dosi.spi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Question;
import fr.univbrest.dosi.spi.dao.*;


@Service
public class QuestionService {
	
	@Autowired
	private  QuestionRepository QstRepository;
	
    public final List<Question> getAll(){
		
		return (List<Question>) QstRepository.findAll();
	}
	
	public final Question updateQuestion(final Question Qst){
		return QstRepository.save(Qst);
	}

	public void addQuestion(final Question qst) {
		QstRepository.save(qst);
	}

	public void deleteQuestion(final long idQuestion) {
		QstRepository.delete(idQuestion);
	}

	public Question getQuestion(final long idQuestion) {
		return QstRepository.findOne(idQuestion);
	}
}
