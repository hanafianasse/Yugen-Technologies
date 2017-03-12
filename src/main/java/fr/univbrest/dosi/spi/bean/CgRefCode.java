package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CG_REF_CODES database table.
 * 
 */
@Entity
@Table(name="CG_REF_CODES")
@NamedQueries({
@NamedQuery(name="CgRefCode.findAll", query="SELECT c FROM CgRefCode c"),
@NamedQuery(name = "CgRefCode.findByIdCgrc", query = "SELECT c FROM CgRefCode c WHERE c.idCgrc = :idCgrc"),
@NamedQuery(name = "CgRefCode.findByRvDomain", query = "SELECT c FROM CgRefCode c WHERE c.rvDomain = :rvDomain")
})
public class CgRefCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CGRC")
	private long idCgrc;

	@Column(name="RV_ABBREVIATION")
	private String rvAbbreviation;

	@Column(name="RV_DOMAIN")
	private String rvDomain;

	@Column(name="RV_HIGH_VALUE")
	private String rvHighValue;

	@Column(name="RV_LOW_VALUE")
	private String rvLowValue;

	@Column(name="RV_MEANING")
	private String rvMeaning;

	public CgRefCode() {
	}

	public long getIdCgrc() {
		return this.idCgrc;
	}

	public void setIdCgrc(long idCgrc) {
		this.idCgrc = idCgrc;
	}

	public String getRvAbbreviation() {
		return this.rvAbbreviation;
	}

	public void setRvAbbreviation(String rvAbbreviation) {
		this.rvAbbreviation = rvAbbreviation;
	}

	public String getRvDomain() {
		return this.rvDomain;
	}

	public void setRvDomain(String rvDomain) {
		this.rvDomain = rvDomain;
	}

	public String getRvHighValue() {
		return this.rvHighValue;
	}

	public void setRvHighValue(String rvHighValue) {
		this.rvHighValue = rvHighValue;
	}

	public String getRvLowValue() {
		return this.rvLowValue;
	}

	public void setRvLowValue(String rvLowValue) {
		this.rvLowValue = rvLowValue;
	}

	public String getRvMeaning() {
		return this.rvMeaning;
	}

	public void setRvMeaning(String rvMeaning) {
		this.rvMeaning = rvMeaning;
	}

}