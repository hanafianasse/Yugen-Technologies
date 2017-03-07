package fr.univbrest.dosi.spi.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Iterables;

import fr.univbrest.dosi.spi.Application;
import fr.univbrest.dosi.spi.bean.Enseignant;
import fr.univbrest.dosi.spi.exception.SPIException;

/**
 * @author DOSI
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EnseignantServiceTests {
	/**
	 *
	 */
	@Autowired
	private EnseignantService enseignantService;
	/**
	 *
	 */
	private Integer noEnseignant;
	/**
	 *
	 */
	private String nom;
	/**
	 *
	 */
	private String prenom;

	/**
	 *
	 */
	@Test
	public final void addEnseignant() {
		final Enseignant enseignant = new Enseignant();
		final Integer id = 8;
		enseignant.setNoEnseignant(id);
		enseignant.setNom("LAHNAKI");
		enseignant.setPrenom("Chakib");
		enseignant.setType("INT");
		enseignant.setSexe("H");
		enseignant.setAdresse("cite universitaire de kergoat");
		enseignant.setCodePostal("29200");
		enseignant.setVille("Brest");
		enseignant.setPays("FR");
		enseignant.setMobile("06.67.58.23.68");
		enseignant.setTelephone("06.67.58.23.00");
		enseignant.setEmailPerso("chakib.lahnaki@gmail.com");
		enseignant.setEmailUbo("chakib.lah@gmail.com");
		try {
			final Enseignant newEnseignant = enseignantService.addEnseignant(enseignant);
			Assert.assertNotNull(newEnseignant.getNoEnseignant());
			Assert.assertEquals(enseignant.getNoEnseignant(), newEnseignant.getNoEnseignant());
			// Assert.fail();
		} catch (final SPIException ex) {
			Assert.assertEquals("l'enseignant que vous souhaitez ajouter exsite déja ", ex.getMessage());
		}
		/*
		 * Enseignant newEnseignant = enseignantService.addEnseignant(enseignant); Assert.assertNotNull(newEnseignant.getNoEnseignant());
		 * Assert.assertEquals(enseignant.getNoEnseignant(),newEnseignant.getNoEnseignant());
		 */
	}

	/**
	 *
	 */
	@Test
	public final void addEnseignantExiste() {
		final Enseignant enseignant = new Enseignant();
		enseignant.setNoEnseignant(1);
		enseignant.setNom("SALIOU");
		enseignant.setPrenom("Philippe");
		enseignant.setType("MCF");
		enseignant.setSexe("H");
		enseignant.setAdresse("6 rue de l'Argoat");
		enseignant.setCodePostal("29860");
		enseignant.setVille("LE DRENNEC");
		enseignant.setPays("FR");
		enseignant.setMobile("06.29.24.01.00");
		enseignant.setTelephone("02.98.01.69.74");
		enseignant.setEmailPerso("philippe.saliou@univ-brest.fr");
		enseignant.setEmailUbo("philippe.saliou@gmail.com");
		try {
			final Enseignant newEnseignant = enseignantService.addEnseignant(enseignant);
			Assert.fail();
		} catch (final SPIException ex) {
			Assert.assertEquals("l'enseignant que vous souhaitez ajouter exsite déja ", ex.getMessage());
		}
	}

	/**
	 *
	 */
	@Test
	public final void deleteEnseignant() {
		final Integer id = 8;
		try {
			enseignantService.deleteEnseignant(id);
			Assert.fail();
		} catch (final SPIException ex) {
			Assert.assertEquals("Cant delete Enseignant", ex.getMessage());
		}
	}

	/**
	 *
	 */
	@Test
	public final void deleteEnseignantNotExist() {
		final Integer id = 9;
		try {
			enseignantService.deleteEnseignant(id);
			Assert.fail();
		} catch (final SPIException ex) {
			Assert.assertEquals("Cant delete Enseignant", ex.getMessage());
		}
	}

	/**
	 *
	 */
	@Test
	public final void getEnseignant() {
		final Enseignant enseignant = enseignantService.getEnseignant(this.noEnseignant);
		Assert.assertNotNull(enseignant);
		Assert.assertEquals(this.nom, enseignant.getNom());
	}

	/**
	 *
	 */
	@Test
	public final void getEnseignantNotExiste() {
		final Enseignant enseignant = enseignantService.getEnseignant(9);
		Assert.assertNotNull(enseignant);
		Assert.assertEquals(this.nom, enseignant.getNom());
		Assert.assertEquals(this.prenom, enseignant.getPrenom());
	}

	/**
	 *
	 */
	@Before
	public final void init() {
		// this.business = new GreetingBusinessImpl();
		this.noEnseignant = 1;
		this.nom = "SALIOU";
		this.prenom = "Philippe";
	}

	@Test
	public void listeEnseignants() {
		final Iterable<Enseignant> listEnseignant = enseignantService.listens();
		Assert.assertNotNull(listEnseignant);
		Assert.assertEquals(6, Iterables.size(listEnseignant));
	}

	@Test
	public void updateEnseignantExist() {
		final Enseignant enseignant = new Enseignant();
		enseignant.setNoEnseignant(1);
		enseignant.setNom("SALI");
		enseignant.setPrenom("Philip");
		enseignant.setType("INT");
		enseignant.setSexe("H");
		enseignant.setAdresse("6 rue de l'Argoat");
		enseignant.setCodePostal("29860");
		enseignant.setVille("LE DRENNEC");
		enseignant.setPays("MA");
		enseignant.setMobile("06.29.55.01.55");
		enseignant.setTelephone("02.98.01.69.74");
		enseignant.setEmailPerso("philippe.saliou@univ-brest.fr");
		enseignant.setEmailUbo("philippe.saliou@gmail.com");
		try {
			final Enseignant newEnseignant = enseignantService.updateEnseignant(enseignant);
			Assert.assertNotNull(newEnseignant.getNoEnseignant());
			Assert.assertEquals(enseignant.getNom(), newEnseignant.getNom());
			// Assert.fail();
		} catch (final SPIException ex) {
			Assert.assertEquals("l'enseignant que vous souhaitez modifier n'exsite pas", ex.getMessage());
		}
	}

	@Test
	public final void updateEnseignantNotExist() {
		final Enseignant enseignant = new Enseignant();
		enseignant.setNoEnseignant(8);
		enseignant.setNom("LAHNAKI");
		enseignant.setPrenom("Chakib");
		enseignant.setType("INT");
		enseignant.setSexe("H");
		enseignant.setAdresse("cite universitaire de kergoat");
		enseignant.setCodePostal("29200");
		enseignant.setVille("Brest");
		enseignant.setPays("FR");
		enseignant.setMobile("06.67.58.23.68");
		enseignant.setTelephone("06.67.58.23.00");
		enseignant.setEmailPerso("chakib.lahnaki@gmail.com");
		enseignant.setEmailUbo("chakib.lah@gmail.com");
		try {
			final Enseignant newEnseignant = enseignantService.updateEnseignant(enseignant);
			Assert.fail();
		} catch (final SPIException ex) {
			Assert.assertEquals("l'enseignant que vous souhaitez modifier n'exsite pas ", ex.getMessage());
		}
	}

}
