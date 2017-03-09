package fr.univbrest.dosi.spi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Formation;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.dao.PromotionRepository;

@Service
public class PromotionService {

	@Autowired
	private PromotionRepository promotionRepository;

	public final Promotion addPromotion(final Promotion promotion) {
		return promotionRepository.save(promotion);
	}

	public final Promotion UpdatePromotion(final Promotion promotion) {
		return promotionRepository.save(promotion);
	}
	public final void deletePromotion(final PromotionPK promotionPK) {
		promotionRepository.delete(promotionPK);
	}
	

	public final Boolean existPromotion(final PromotionPK promotionPK) {
		return promotionRepository.exists(promotionPK);
	}

	public final Promotion getPromotion(final PromotionPK promotionPK) {
		return promotionRepository.findOne(promotionPK);
	}

	public final List<Promotion> getPromotionByEnseignant(final Integer noEnseignant) {
		return promotionRepository.findByNoEnseignant(noEnseignant);
	}
	
	public final List<Promotion> getPromotionByCodeFormation(final Formation f) {
		return promotionRepository.findByFormation(f);
	}
	
	public final List<Etudiant> getEtudiants(PromotionPK promotionPK ) {
		Promotion promotion = promotionRepository.findOne(promotionPK);
		return (List<Etudiant>)promotion.getEtudiantCollection();
	}
	
	public final Iterable<Promotion> listPromotions(){
		final Iterable<Promotion> promotions = promotionRepository.findAll();
		return promotions;
	}

	

}
