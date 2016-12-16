package fi.haagahelia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "kysymys_tyyppi")
public class Tyyppi {
	
	@Id
	@JsonProperty("tyyppi_id")
	@Column(name="tyyppi_id")
	private int id;
	
	@JsonProperty("tyyppi_nimi")
	@Column(name="tyyppi_nimi")
	private String nimi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	

}
