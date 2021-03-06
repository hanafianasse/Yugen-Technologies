package fr.univbrest.dosi.spi.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the QUALIFICATIF database table.
 * 
 */
@Entity
@NamedQuery(name = "Qualificatif.findAll", query = "SELECT q FROM Qualificatif q")
public class Qualificatif implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq_qua")
	@SequenceGenerator(name = "my_seq_qua", sequenceName = "QUA_SEQ")
	@Column(name = "ID_QUALIFICATIF")
	private long idQualificatif;

	private String maximal;

	private String minimal;

	public Qualificatif()
	{
	}

	public long getIdQualificatif()
	{
		return this.idQualificatif;
	}

	public void setIdQualificatif(long idQualificatif)
	{
		this.idQualificatif = idQualificatif;
	}

	public String getMaximal()
	{
		return this.maximal;
	}

	public void setMaximal(String maximal)
	{
		this.maximal = maximal;
	}

	public String getMinimal()
	{
		return this.minimal;
	}

	public void setMinimal(String minimal)
	{
		this.minimal = minimal;
	}

}