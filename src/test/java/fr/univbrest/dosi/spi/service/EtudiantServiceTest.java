package fr.univbrest.dosi.spi.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.spi.Application;
import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.dao.EtudiantRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EtudiantServiceTest {

	


	@Test
	public void doitAjouterEtudiant() {
		EtudiantRepository entrepot = new EtudiantDAOStub();
		EtudiantService etudiantService = new EtudiantService(entrepot);
		etudiantService.addEtudiant(new Etudiant());
		Assert.assertEquals(1, entrepot.count());
	}
	
	@Test
	public void doitRécupérerLesEtudiants(){
		List<Etudiant> etudiants=Lists.newArrayList(new Etudiant("12"),new Etudiant("13"),new Etudiant("14"));
		EtudiantRepository entrepot = new EtudiantDAOStub(etudiants);
		EtudiantService etudiantService = new EtudiantService(entrepot);
		
		Assert.assertEquals(3, etudiantService.getAll().size());
		
	}
	
	@Test
	public void doitSupprimerUnEtudiant(){
		List<Etudiant> etudiants=Lists.newArrayList(new Etudiant("12"),new Etudiant("13"),new Etudiant("14"));
		EtudiantRepository entrepot = new EtudiantDAOStub(etudiants);
		EtudiantService etudiantService = new EtudiantService(entrepot);
		etudiantService.deleteEtudiant("12");
		Assert.assertEquals(2,etudiantService.getAll().size());
		
	}
	
}
