/**
 * 
 */
package fr.univbrest.dosi.spi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.bean.Rubrique;
import fr.univbrest.dosi.spi.bean.RubriqueQuestion;
import fr.univbrest.dosi.spi.bean.RubriqueQuestionPK;
import fr.univbrest.dosi.spi.dao.RubriqueQuestionRepository;
import fr.univbrest.dosi.spi.exception.SPIException;

/**
 * @author Chobaz
 *
 *         9 mars 2017
 */
@Service
public class RubriqueQuestionService
{
	private RubriqueQuestionRepository rubriqueQuestionRepository;

	@Autowired
	public RubriqueQuestionService(RubriqueQuestionRepository entrepot)
	{
		this.rubriqueQuestionRepository = entrepot;
	}

	public RubriqueQuestion addRubriqueQuestion(RubriqueQuestion rubriqueQuestion)
	{
		return rubriqueQuestionRepository.save(rubriqueQuestion);
	}

	public RubriqueQuestion updateRubriqueQuestion(RubriqueQuestion rubriqueQuestion)
	{
		//Vérification que le rubriqueQuestion à modifier existe
		if (rubriqueQuestionRepository.exists(rubriqueQuestion.getId()))
			return rubriqueQuestionRepository.save(rubriqueQuestion);
		else
			throw new SPIException("RubriqueQuestion introuvable !");
	}

	public void deleteRubriqueQuestion(RubriqueQuestion rubriqueQuestion)
	{
		//Vérification que le rubriqueQuestion à supprimer existe
		if (rubriqueQuestionRepository.exists(rubriqueQuestion.getId()))
			rubriqueQuestionRepository.delete(rubriqueQuestionRepository
					.findOne(rubriqueQuestion.getId()));
		else
			throw new SPIException("RubriqueQuestion introuvable !");
	}

	public RubriqueQuestion getRubriqueQuestion(RubriqueQuestion rubriqueQuestion)
	{
		return rubriqueQuestionRepository.findOne(rubriqueQuestion.getId());
	}
	
	public final List<RubriqueQuestion> getRubriqueQuestions(long R) {
		return rubriqueQuestionRepository.findById_IdRubrique(R);
	}

	public Iterable<RubriqueQuestion> getAll()
	{
		return rubriqueQuestionRepository.findAll();
	}

}
