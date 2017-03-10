package fr.univbrest.dosi.spi.bean;

public class PromotionEtudiant {

	private Etudiant etudiant;
	private Promotion promotion;
	 
	public PromotionEtudiant() {
		super();
	}
	
	public PromotionEtudiant(Etudiant etudiant,Promotion promotion) {
		super();
		this.etudiant=etudiant;
		this.promotion=promotion;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
}
