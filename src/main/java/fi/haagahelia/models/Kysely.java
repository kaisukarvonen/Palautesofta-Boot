package fi.haagahelia.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"kyselyn_nimi", "kysely_id", "kysymykset"})
@Entity
@Table(name = "kysely")
public class Kysely {

	
	@JsonProperty("kyselyn_nimi")
	@Column(name="kysely_nimi")
	private String nimi;
	
	@Id
	@JsonProperty("kysely_id")
	@Column(name="kysely_id")
	private int id;
	
	@Transient
	private List<Kysymys> kysymykset = new ArrayList<Kysymys>();
	

	public Kysely(int id) {
		this.id = id;
	}
	
	
	public Kysely() {
	}
	
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}
	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}
	
	public void addToList(Kysymys k) {
		kysymykset.add(k);
	}
	
	public String toString() {
		return "kysely_nimi: "+this.getNimi()+ "\n"+this.getKysymykset();
	}
	

}
