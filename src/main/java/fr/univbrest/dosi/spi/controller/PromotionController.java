package fr.univbrest.dosi.spi.controller;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Formation;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.service.PromotionService;
import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/promotion")
@Api(value = "promotion", description = "Description de la ressource promotion.")
public class PromotionController
{

	@Autowired
	private PromotionService promotionService;

	// afficher ttes les promotions
	@RequestMapping(produces = "application/json",method = RequestMethod.GET)
	public final Collection<Promotion> getAll()
	{
		return (Collection<Promotion>) promotionService.listPromotions();
	}

	// afficher les promotions d'une formation spécifique

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{codeFormation}")
	public final Iterable<Promotion> PromotionByFormation(
			@PathVariable(value = "codeFormation") final String codeFormation)
	{
		Formation f = new Formation(codeFormation);
		return promotionService.getPromotionByCodeFormation(f);
	}

	// Afficher les etudiants selon la promotion
	@RequestMapping(value = "/{codeFormation}/{anneeUniversitaire}", method = RequestMethod.GET, produces = "application/json")
	public final List<Etudiant> GetEtudiantByPromotion(
			@PathVariable(value = "codeFormation") final String CodeFormation,
			@PathVariable(value = "anneeUniversitaire") final String anneeUniversitaire)
	{
		PromotionPK promotionPk = new PromotionPK(CodeFormation,
				anneeUniversitaire);
		return promotionService.getEtudiants(promotionPk);
	}
	
	@RequestMapping(value = "/getpromotionby/{codeFormation}/{anneeUniversitaire}",method = RequestMethod.GET,produces="application/json")
	 public final Promotion getPromotion(
			 @PathVariable(value="codeFormation") final String CodeFormation,
			 @PathVariable(value="anneeUniversitaire") final String anneeUniversitaire){
		PromotionPK promotionPk = new PromotionPK(CodeFormation,anneeUniversitaire);
		return promotionService.getPromotion(promotionPk);
	}

	// Ajouter une nouvelle promotion
	@RequestMapping(method = RequestMethod.POST)
	public Promotion addPromotion(@RequestBody Promotion promotion){
		return promotionService.addPromotion(promotion);
	}

	// Modifier une promotion
	@RequestMapping(method = RequestMethod.PUT)
	public Promotion updatePromotion(@RequestBody Promotion promotion)
	{
		return promotionService.UpdatePromotion(promotion);
	}

	// Supprimer une promotion
	@RequestMapping(method = RequestMethod.DELETE)
	public void deletePromotion(@RequestBody PromotionPK promotionPK)
	{
		promotionService.deletePromotion(promotionPK);
	}
	
	//Nombre de promotions
	@RequestMapping(value = "/nombrePromotions", method = RequestMethod.GET)
	public int nombrePromotions() {
		return promotionService.nombrePromotions();
	}
	
	//Récupération des promotions de l'année en cours
	@RequestMapping(value = "/promotionsEnCours", method = RequestMethod.GET)
	public Collection<Promotion> getPromotionsEnCours()
	{
		//DatetimeFormatter qui va permettre de convertir les dates sous format String en LocalDate
		DateTimeFormatter dtf = DateTimeFormat.forPattern("YYYY");
		
		//Date actuelle
		LocalDate actualDate = new DateTime().toLocalDate();
		
		//Liste des promotions en cours à retourner
		List<Promotion> promotionsEnCours = new ArrayList<Promotion>();
		
		for(Promotion p: promotionService.listPromotions())
		{
			//Récupération des bornes de l'année universitaire sous forme d'objets LocalDate
			LocalDate minDate = dtf.parseLocalDate(p.getPromotionPK().getAnneeUniversitaire().substring(0, 4));
			LocalDate maxDate = dtf.parseLocalDate(p.getPromotionPK().getAnneeUniversitaire().substring(5, 9));
			
			//Configuration de la date de début de l'année universitaire
			minDate = minDate.plusMonths(8);
			
			//Configuration de la date de fin de l'année universitaire
			maxDate = maxDate.plusMonths(7);
			maxDate = maxDate.plusDays(30);
			
			if(!actualDate.isBefore(minDate) && !actualDate.isAfter(maxDate))
				promotionsEnCours.add(p);
		}
		
		return promotionsEnCours;
	}

}
