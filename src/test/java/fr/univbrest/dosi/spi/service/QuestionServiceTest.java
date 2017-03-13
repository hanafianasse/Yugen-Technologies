package fr.univbrest.dosi.spi.service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.spi.Application;
import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Question;
import fr.univbrest.dosi.spi.dao.EtudiantRepository;
import fr.univbrest.dosi.spi.dao.QuestionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class QuestionServiceTest {
	

	
	@Test
	public void addQstTest(){
		
			/**
			 * Instanciation du service de Question via l'entrepot
			 */
			QuestionRepository entrepot = new QuestionDAOStub();
			QuestionService QstService= new QuestionService(entrepot);
			QstService.addQuestion(new Question());
			Assert.assertEquals(1, entrepot.count());
		}
		
		
		@Test
		public void UpdateTest() {
		
		/**
		 * Instanciation du service de Question via l'entrepot
		 */
		QuestionRepository entrepot = new QuestionDAOStub();
		QuestionService QuestionService = new QuestionService(entrepot);

		/**
		 * Ajout d'une Question
		 */
		Question Question = new Question();
		Question.setIntitule("Question1");
		QuestionService.addQuestion(Question);

		/**
		 * Test de l'ajout
		 */
		Assert.assertEquals(1, entrepot.count());

		/**
		 * Modification du Question
		 */
		Question.setIntitule("QuestionUp");
    	QuestionService.updateQuestion(Question);

		/**
		 * Test de la modification
		 */
		Assert.assertEquals("QuestionUp",((QuestionDAOStub) entrepot).getDonnees().get(((QuestionDAOStub) entrepot).getDonnees().size() - 1).getIntitule());
		
	}
		
		@Test
		public void doitSupprimerQuestion()
		{
			/**
			 * Instanciation du service de Question via l'entrepot
			 */
			QuestionRepository entrepot = new QuestionDAOStub();
			QuestionService QuestionService = new QuestionService(entrepot);

			/**
			 * Ajout d'un Question
			 */
			Question q = new Question();
			q = new Question();
			q.setIdQuestion(new Long(26));
			q.setIntitule("q1");
			q.setNoEnseignant(new BigDecimal(2));
			q.setType("QUS");
			QuestionService.addQuestion(q);

			/**
			 * Test de l'ajout
			 */
			Assert.assertEquals(1, entrepot.count());

			/**
			 * Suppression du Question
			 */
			QuestionService.deleteQuestion(q.getIdQuestion());

			/**
			 * Test de la suppression
			 */
			Assert.assertEquals(0, entrepot.count());
		}
		
		@Test
		public void doitRecupererQuestions()
		{
			/**
			 * Instanciation du service de Question via l'entrepot
			 */
			QuestionRepository entrepot = new QuestionDAOStub();
			QuestionService QuestionService = new QuestionService(entrepot);

			/**
			 * Ajout de plusieurs Questions
			 */
			Question Question_1 = new Question();
			Question Question_2 = new Question();
			Question Question_3 = new Question();

			QuestionService.addQuestion(Question_1);
			QuestionService.addQuestion(Question_2);
			QuestionService.addQuestion(Question_3);

			/**
			 * Test de la récupération
			 */
			Assert.assertEquals(3, QuestionService.getAll().spliterator().getExactSizeIfKnown());
		}
		
		@Test
		public void doitRecupererQuestion()
		{
			/**
			 * Instanciation du service de Question via l'entrepot
			 */
			QuestionRepository entrepot = new QuestionDAOStub();
			QuestionService QuestionService = new QuestionService(	entrepot);

			/**
			 * Ajout d'un Question
			 */
			Question q = new Question();
		
			q.setIdQuestion(new Long(26));
			q.setIntitule("q1");
			q.setNoEnseignant(new BigDecimal(2));
			q.setType("QUS");
			QuestionService.addQuestion(q);
		

			/**
			 * Récupération d'une Question
			 */
			Question Question_recupere = QuestionService.getQuestion(1);

			/**
			 * Test de la récupération
			 */
			Assert.assertNotNull(Question_recupere);
		}


		

	 
}
