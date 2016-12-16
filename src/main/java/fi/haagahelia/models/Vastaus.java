package fi.haagahelia.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "vastaus")
public class Vastaus {
	
	@JsonProperty("vastaus_arvo")
	@Column(name="vastaus_nimi")
	private String nimi;
	
	@JsonProperty("kysymys_id")
	@Column(name="kysymys_id")
	private int kysymysId;

	@JsonIgnore
	@Id
	@GeneratedValue
	@Column(name="vastaus_id")
	private int id;
	
	/*@JsonIgnore
	@ManyToOne
	private Kysymys kysym;*/
 
	public Vastaus() {
		super();
	}

	public Vastaus(String nimi) {
			this.nimi = nimi;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public int getKysymysId() {
		return kysymysId;
	}

	public void setKysymysId(int id) {
		this.kysymysId = id; 
	}

	public String toString() {
		return "vastaus: " +this.getNimi();
	}

	/*public Kysymys getKysym() {
		return kysym;
	}

	public void setKysym(Kysymys kysymys) {
		this.kysym = kysymys;
	}*/

}
