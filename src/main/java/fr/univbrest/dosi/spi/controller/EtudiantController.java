package fr.univbrest.dosi.spi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.service.EtudiantService;
import fr.univbrest.dosi.spi.service.PromotionService;

@RestController
@RequestMapping(value = "/etudiant")
public class EtudiantController
{

	@Autowired
	private EtudiantService etudiantService;

	@Autowired
	private PromotionService promotionService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Etudiant> getAll()
	{
		return etudiantService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Etudiant addEtudiant(Etudiant etudiant)
	{
		return etudiantService.addEtudiant(etudiant);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{codeFormation}/{anneeUniversitaire}")
	public List<Etudiant> getEtudiantByPromotion(
			@PathVariable("codeFormation") String codeFormation,
			@PathVariable("anneeUniversitaire") String anneeUniversitaire)
	{
		PromotionPK promotionPk = new PromotionPK(codeFormation,
				anneeUniversitaire);
		Promotion promotion = promotionService.getPromotion(promotionPk);
		return etudiantService.getEtudiantByPromotion(promotion);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{noEtudiant}")
	public Etudiant getEtudiant(@PathVariable("noEtudiant") String noEtudiant)
	{
		return etudiantService.getEtudiant(noEtudiant);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteEtudiant(@RequestBody String noEtudiant)
	{
		etudiantService.deleteEtudiant(noEtudiant);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Etudiant updateEtudiant(Etudiant etudiant)
	{
		return etudiantService.updateEtudiant(etudiant);
	}
}
