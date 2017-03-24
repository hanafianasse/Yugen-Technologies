/**
 * 
 */
package fr.univbrest.dosi.spi.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.QuestionEvaluation;
import fr.univbrest.dosi.spi.dao.QuestionEvaluationRepository;
import fr.univbrest.dosi.spi.exception.SPIException;

/**
 * @author Chobaz
 *
 *         21 mars 2017
 */
@Service
public class QuestionEvaluationService
{
	private QuestionEvaluationRepository questionEvaluationRepository;

	@Autowired
	public QuestionEvaluationService(QuestionEvaluationRepository entrepot)
	{
		this.questionEvaluationRepository = entrepot;
	}

	public QuestionEvaluation addQuestionEvaluation(
			QuestionEvaluation questionEvaluation)
	{
		return questionEvaluationRepository.save(questionEvaluation);
	}

	public QuestionEvaluation updateQuestionEvaluation(
			QuestionEvaluation questionEvaluation)
	{
		// Vérification que la questionEvaluation à modifier existe
		if (questionEvaluationRepository.exists(questionEvaluation
				.getIdQuestionEvaluation()))
			return questionEvaluationRepository.save(questionEvaluation);
		else
			throw new SPIException("QuestionEvaluation introuvable !");
	}

	public void deleteQuestionEvaluation(long idQuestionEvaluation)
	{
		// Vérification que la questionEvaluation à supprimer existe
		if (questionEvaluationRepository.exists(idQuestionEvaluation))
			questionEvaluationRepository.delete(questionEvaluationRepository
					.findOne(idQuestionEvaluation));
		else
			throw new SPIException("QuestionEvaluation introuvable !");
	}

	public QuestionEvaluation getQuestionEvaluation(long idQuestionEvaluation)
	{
		return questionEvaluationRepository.findOne(idQuestionEvaluation);
	}

	public Iterable<QuestionEvaluation> getAll()
	{
		return questionEvaluationRepository.findAll();
	}
	
	//List des QuestionEvaluations par l'id de la RubriqueEvaluation
	public Iterable<QuestionEvaluation> getQuestionEvaluationByIdRubriqueEvaluation(BigDecimal idRubriqueEvaluation)
	{
		return questionEvaluationRepository.findByIdRubriqueEvaluation(idRubriqueEvaluation);
	}
}
