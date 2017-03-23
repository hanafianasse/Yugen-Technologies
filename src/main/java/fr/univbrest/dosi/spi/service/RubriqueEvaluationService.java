/**
 * 
 */
package fr.univbrest.dosi.spi.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.RubriqueEvaluation;
import fr.univbrest.dosi.spi.dao.RubriqueEvaluationRepository;
import fr.univbrest.dosi.spi.exception.SPIException;

/**
 * @author Chobaz
 *
 * 21 mars 2017
 */
@Service
public class RubriqueEvaluationService
{
	private RubriqueEvaluationRepository rubriqueEvaluationRepository;
	
	@Autowired
	public RubriqueEvaluationService(RubriqueEvaluationRepository entrepot)
	{
		this.rubriqueEvaluationRepository = entrepot;
	}
	
	public RubriqueEvaluation addRubriqueEvaluation(RubriqueEvaluation rubriqueEvaluation)
	{
		return rubriqueEvaluationRepository.save(rubriqueEvaluation);
	}
	
	public RubriqueEvaluation updateRubriqueEvaluation(RubriqueEvaluation rubriqueEvaluation)
	{
		//Vérification que la rubriqueEvaluation à modifier existe
		if(rubriqueEvaluationRepository.exists(rubriqueEvaluation.getIdRubriqueEvaluation()))
			return rubriqueEvaluationRepository.save(rubriqueEvaluation);
		else
			throw new SPIException("RubriqueEvaluation introuvable !");
	}
	
	public void deleteRubriqueEvaluation(long idRubriqueEvaluation)
	{
		//Vérification que la rubriqueEvaluation à supprimer existe
		if(rubriqueEvaluationRepository.exists(idRubriqueEvaluation))
			rubriqueEvaluationRepository.delete(rubriqueEvaluationRepository.findOne(idRubriqueEvaluation));
		else
			throw new SPIException("RubriqueEvaluation introuvable !");
	}
	
	public RubriqueEvaluation getRubriqueEvaluation(long idRubriqueEvaluation)
	{
		return rubriqueEvaluationRepository.findOne(idRubriqueEvaluation);
	}
	
	public Iterable<RubriqueEvaluation> getAll()
	{
		return rubriqueEvaluationRepository.findAll();
	}
	
	//Liste des RubriqueEvaluations par l'id de l'évaluation
	public Iterable<RubriqueEvaluation> getRubriqueEvaluationByIdEvaluation(BigDecimal idEvaluation)
	{
		return rubriqueEvaluationRepository.findByIdEvaluation(idEvaluation);
	}
	
}
