package fr.univbrest.dosi.spi.controller;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionEtudiant;
import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.service.AuthentificationService;
import fr.univbrest.dosi.spi.service.EtudiantService;
import fr.univbrest.dosi.spi.service.PromotionService;
import io.swagger.annotations.Api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/etudiant")
@Api(value = "etudiant", description = "Description de la ressource etudiant.")
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;

	@Autowired
	private PromotionService promotionService;

	@Autowired
	private AuthentificationService authentificationService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Etudiant> getAll() {
		return etudiantService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Etudiant addEtudiant(@RequestBody PromotionEtudiant promotionEtudiant) {
		Promotion promotion = promotionService.getPromotion(promotionEtudiant
				.getPromotion().getPromotionPK());
		Etudiant etudiant = promotionEtudiant.getEtudiant();
		etudiant.setPromotion(promotion);
		return etudiantService.addEtudiant(etudiant);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{codeFormation}/{anneeUniversitaire}")
	public List<Etudiant> getEtudiantByPromotion(
			@PathVariable("codeFormation") String codeFormation,
			@PathVariable("anneeUniversitaire") String anneeUniversitaire) {
		PromotionPK promotionPk = new PromotionPK(codeFormation,
				anneeUniversitaire);
		Promotion promotion = promotionService.getPromotion(promotionPk);
		return etudiantService.getEtudiantByPromotion(promotion);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{noEtudiant}")
	public Etudiant getEtudiant(@PathVariable("noEtudiant") String noEtudiant) {
		return etudiantService.getEtudiant(noEtudiant);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/size")
	public int size() {
		return this.getAll().size();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{noEtudiant}")
	public void deleteEtudiant(@PathVariable("noEtudiant") String noEtudiant) {
		if (authentificationService.getAuthentificationByNoEtudiant(noEtudiant) != null)
			authentificationService
					.deleteAuthentification(authentificationService
							.getAuthentificationByNoEtudiant(noEtudiant)
							.getIdConnection());

		etudiantService.deleteEtudiant(noEtudiant);
	}

	@RequestMapping(value = "/{oldNoEtudiant}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Etudiant updateEtudiant(@RequestBody PromotionEtudiant promotionEtudiant,@PathVariable("oldNoEtudiant") String oldNoEtudiant) {
		Promotion promotion = promotionService.getPromotion(promotionEtudiant
				.getPromotion().getPromotionPK());
		Etudiant etudiant = promotionEtudiant.getEtudiant();
		etudiant.setPromotion(promotion);
		return etudiantService.updateEtudiant(etudiant,oldNoEtudiant);
	}

	// Nombre des etudiants total
	@RequestMapping(value = "/nombreEtudiants")
	public String nombreEtudiants() {
		return String.valueOf(etudiantService.nombreEtudiants());
	}
	
	/**
	 * Nombre des etudiants par promotion
	 * 
	 * @return int casted to string 
	 */
	@RequestMapping(value = "/nombreEtudiants/{codeFormation}/{anneeUniversitaire}", method = RequestMethod.GET)
	public String nombreEtudiantsParFormation(@PathVariable("codeFormation") String codeFormation, @PathVariable("anneeUniversitaire") String anneeUniversitaire)
	{
		return String.valueOf(etudiantService.getAll().stream().filter(e -> e.getPromotion().getFormation().getCodeFormation().equals(codeFormation) && e.getPromotion().getPromotionPK().getAnneeUniversitaire().equals(anneeUniversitaire)).collect(Collectors.toList()).size());
	}

}
