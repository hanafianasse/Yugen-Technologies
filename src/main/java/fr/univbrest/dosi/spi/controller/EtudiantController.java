package fr.univbrest.dosi.spi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionEtudiant;
import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.service.AuthentificationService;
import fr.univbrest.dosi.spi.service.EtudiantService;
import fr.univbrest.dosi.spi.service.PromotionService;

@RestController
@RequestMapping(value = "/etudiant")
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

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{noEtudiant}")
	public void deleteEtudiant(@PathVariable("noEtudiant") String noEtudiant) {
		if (authentificationService.getAuthentificationByNoEtudiant(noEtudiant) != null)
			authentificationService
					.deleteAuthentification(authentificationService
							.getAuthentificationByNoEtudiant(noEtudiant)
							.getIdConnection());

		etudiantService.deleteEtudiant(noEtudiant);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Etudiant updateEtudiant(
			@RequestBody PromotionEtudiant promotionEtudiant) {
		Promotion promotion = promotionService.getPromotion(promotionEtudiant
				.getPromotion().getPromotionPK());
		Etudiant etudiant = promotionEtudiant.getEtudiant();
		etudiant.setPromotion(promotion);

		return etudiantService.updateEtudiant(etudiant);
	}
}
