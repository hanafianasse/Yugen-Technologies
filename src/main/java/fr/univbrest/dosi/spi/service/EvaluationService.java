package fr.univbrest.dosi.spi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Evaluation;
import fr.univbrest.dosi.spi.dao.EvaluationRepository;
/**
 * 
 * @author red1 & Marwane
 *
 */

@Service
public class EvaluationService {
@Autowired
private EvaluationRepository evaluationRepository;

public Evaluation getEvaluation (long idEvaluation) {
	Evaluation evaluation =evaluationRepository.findOne(idEvaluation);
	return evaluation;
}

public Iterable<Evaluation > listEvaluations () {
	Iterable<Evaluation > evaluations =evaluationRepository.findAll();
	return evaluations;
}

public void deleteEvaluation (final long idEvaluation){
	evaluationRepository.delete(idEvaluation);
}
 
public Evaluation addEvaluation (final Evaluation evaluation){
	return evaluationRepository.save(evaluation);
}
public Evaluation updateEvaluation (final Evaluation evaluation){
	return evaluationRepository.save(evaluation);
}

}

