package fr.univbrest.dosi.spi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.dao.PromotionRepository;

@Service
public class PromotionService {

	@Autowired
	private PromotionRepository promotionRepository;

	public final void addPromotion(final Promotion promotion) {
		promotionRepository.save(promotion);
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

}
