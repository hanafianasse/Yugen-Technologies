/**
 * 
 */
package fr.univbrest.dosi.spi.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.univbrest.dosi.spi.service.RubriqueEvaluationService;

/**
 * @author Chobaz
 *
 * 21 mars 2017
 */
@RunWith(MockitoJUnitRunner.class)
public class RubriqueEvaluationControllerTest
{
	@InjectMocks
	RubriqueEvaluationController rubriqueEvaluationController;
	
	@Mock
	RubriqueEvaluationService rubriqueEvaluationService;
	
	String url = "http://localhost:8090/rubriqueEvaluation";
	
	@Test
	public void doitAjouterRubriqueEvaluation()
	{
		/**
		 * Instanciation d'une nouvelle rubriqueEvaluation
		 */
		//Evaluation evaluation = new Evaluation();
		//evaluation.setIdEvaluation(9999);
		
		
	}
	
	@Test
	public void doitModifierRubriqueEvaluation()
	{
		
	}
	
	@Test
	public void doitSupprimerRubriqueEvaluation()
	{
		
	}
	
	@Test
	public void doitRecupererRubriqueEvaluation()
	{
		
	}
	
	@Test
	public void doitRecupererRubriqueEvaluations()
	{
		
	}

}
