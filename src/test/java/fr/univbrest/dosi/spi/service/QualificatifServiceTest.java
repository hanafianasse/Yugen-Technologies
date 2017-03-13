/**
 * 
 */
package fr.univbrest.dosi.spi.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.spi.Application;
import fr.univbrest.dosi.spi.bean.Qualificatif;
import fr.univbrest.dosi.spi.dao.QualificatifRepository;

/**
 * @author Chobaz
 *
 *         10 mars 2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class QualificatifServiceTest
{
	
	@Test
	public void doitAjouterQualificatif()
	{
		/**
		 * Instanciation du service de Qualificatif via l'entrepot
		 */
		QualificatifRepository entrepot = new QualificatifDAOStub();
		QualificatifService qualificatifService = new QualificatifService(
				entrepot);

		/**
		 * Ajout d'un qualificatif
		 */
		qualificatifService.addQualificatif(new Qualificatif());

		/**
		 * Test de l'ajout
		 */
		Assert.assertEquals(1, entrepot.count());
	}

	@Test
	public void doitModifierQualificatif()
	{
		/**
		 * Instanciation du service de Qualificatif via l'entrepot
		 */
		QualificatifRepository entrepot = new QualificatifDAOStub();
		QualificatifService qualificatifService = new QualificatifService(
				entrepot);

		/**
		 * Ajout d'un qualificatif
		 */
		Qualificatif qualificatif = new Qualificatif();
		qualificatif.setIdQualificatif(1);
		qualificatif.setMaximal("Expert");
		qualificatif.setMinimal("Noob");

		qualificatifService.addQualificatif(qualificatif);

		/**
		 * Test de l'ajout
		 */
		Assert.assertEquals(1, entrepot.count());

		/**
		 * Modification du qualificatif
		 */
		qualificatif.setMinimal("Débutant");

		qualificatifService.updateQualificatif(qualificatif);

		/**
		 * Test de la modification
		 */
		Assert.assertEquals(
				"Débutant",
				((QualificatifDAOStub) entrepot).donnees.get(
						((QualificatifDAOStub) entrepot).donnees.size() - 1)
						.getMinimal());
	}

	@Test
	public void doitSupprimerQualificatif()
	{
		/**
		 * Instanciation du service de Qualificatif via l'entrepot
		 */
		QualificatifRepository entrepot = new QualificatifDAOStub();
		QualificatifService qualificatifService = new QualificatifService(
				entrepot);

		/**
		 * Ajout d'un qualificatif
		 */
		Qualificatif qualificatif = new Qualificatif();
		qualificatif.setIdQualificatif(1);
		qualificatif.setMaximal("Expert");
		qualificatif.setMinimal("Noob");

		qualificatifService.addQualificatif(qualificatif);

		/**
		 * Test de l'ajout
		 */
		Assert.assertEquals(1, entrepot.count());

		/**
		 * Suppression du qualificatif
		 */
		qualificatifService
				.deleteQualificatif(qualificatif.getIdQualificatif());

		/**
		 * Test de la suppression
		 */
		Assert.assertEquals(1, entrepot.count());
	}

	@Test
	public void doitRecupererQualificatif()
	{
		/**
		 * Instanciation du service de Qualificatif via l'entrepot
		 */
		QualificatifRepository entrepot = new QualificatifDAOStub();
		QualificatifService qualificatifService = new QualificatifService(
				entrepot);

		/**
		 * Ajout d'un qualificatif
		 */
		Qualificatif qualificatif = new Qualificatif();
		qualificatif.setIdQualificatif(1);
		qualificatif.setMaximal("Expert");
		qualificatif.setMinimal("Noob");

		qualificatifService.addQualificatif(qualificatif);

		/**
		 * Récupération d'un qualificatif
		 */
		Qualificatif qualificatif_recupere = qualificatifService
				.getQualificatif(1);

		/**
		 * Test de la récupération
		 */
		Assert.assertNotNull(qualificatif_recupere);
	}

	@Test
	public void doitRecupererQualificatifs()
	{
		/**
		 * Instanciation du service de Qualificatif via l'entrepot
		 */
		QualificatifRepository entrepot = new QualificatifDAOStub();
		QualificatifService qualificatifService = new QualificatifService(
				entrepot);

		/**
		 * Ajout de plusieurs qualificatifs
		 */
		Qualificatif qualificatif_1 = new Qualificatif();
		Qualificatif qualificatif_2 = new Qualificatif();
		Qualificatif qualificatif_3 = new Qualificatif();

		qualificatifService.addQualificatif(qualificatif_1);
		qualificatifService.addQualificatif(qualificatif_2);
		qualificatifService.addQualificatif(qualificatif_3);

		/**
		 * Test de la récupération
		 */
		Assert.assertEquals(3, qualificatifService.getAll().spliterator()
				.getExactSizeIfKnown());
	}

}
