package fr.univbrest.dosi.spi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Formation;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.service.PromotionService;

@RestController
public class PromotionController {

	@Autowired
	private PromotionService promotionService ; 
	

	
	//afficher ttes les promotions 
	@RequestMapping(produces="application/json", value="/promotions")
	public final Iterable<Promotion> promotions(){
		final Iterable<Promotion> promotions = promotionService.listPromotions();
		for(final Promotion pro : promotions){
			
			System.out.println("ok traitement" + pro.getNbMaxEtudiant());
			
		}
		return promotionService.listPromotions();

	}
	
	//afficher les promotions d'une formation spécifique
	
	@RequestMapping(method = RequestMethod.GET,produces="application/json",value="/promotion/{codeFormation}")
 public final Iterable<Promotion> PromotionByFormation(@PathVariable(value="codeFormation") final String codeFormation){
	 Formation f = new Formation(codeFormation);
	 return promotionService.getPromotionByCodeFormation(f);
 }
	//Afficher les etudiants selon la promotion
	@RequestMapping(value = "/promotion/{codeFormation}/{anneeUniversitaire}",method = RequestMethod.GET,produces="application/json")
	 public final List<Etudiant> GetEtudiantByPromotion(
			 @PathVariable(value="codeFormation") final String CodeFormation,
			 @PathVariable(value="anneeUniversitaire") final String anneeUniversitaire){
		PromotionPK promotionPk = new PromotionPK(CodeFormation,anneeUniversitaire);
		return promotionService.getEtudiants(promotionPk);
	}
	
	@RequestMapping(value = "/getpromotionby/{codeFormation}/{anneeUniversitaire}",method = RequestMethod.GET,produces="application/json")
	 public final Promotion getPromotion(
			 @PathVariable(value="codeFormation") final String CodeFormation,
			 @PathVariable(value="anneeUniversitaire") final String anneeUniversitaire){
		PromotionPK promotionPk = new PromotionPK(CodeFormation,anneeUniversitaire);
		return promotionService.getPromotion(promotionPk);
	}
	
	//Ajouter une nouvelle promotion 
	@RequestMapping(method = RequestMethod.POST, value="/addpromotions")
	public Promotion addPromotion(Promotion promotion) {
		return promotionService.addPromotion(promotion);
	}
	
	//Modifier une promotion
	@RequestMapping(method = RequestMethod.PUT, value="/updpromotions")
	public Promotion UpdatePromotion(Promotion promotion) {
		return promotionService.UpdatePromotion(promotion);
	}
 
 //Supprimer une promotion 
	@RequestMapping(method = RequestMethod.DELETE, value="/delpromotions")
	public void DeletePromotion(PromotionPK promotionPK) {
		 promotionService.deletePromotion(promotionPK);
	}
 
}












