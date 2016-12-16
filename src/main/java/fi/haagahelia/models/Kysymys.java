package fi.haagahelia.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"kysely_id", "kysymys_id", "tyyppi_id", "kysymys_arvo", "vastausvaihtoehdot", "vastaukset"})
@Entity(name= "kysymys")
@Table(name = "kysymys")
public class Kysymys {
	
	@JsonProperty("kysymys_arvo")
	@Column(name="kysymys_nimi")
	private String nimi;
	
	@Column(name="vaihtoehdot")
	@JsonProperty("vastausvaihtoehdot")
	private String vastausvaihtoehdot;
	

	@Id
	@JsonProperty("kysymys_id")
	@Column(name="kysymys_id")
	private int id;
	
	
	@OneToMany
	@JoinColumn(name="kysymys_id")
	private List<Vastaus> vastaukset = new ArrayList<Vastaus>();
	
	@JsonIgnore
	@Transient
	private Kysely kysely;
	
	@JsonProperty("kysely_id")
	@Column(name="kysely_id")
	private int kyselyid;
	


	@JsonProperty("tyyppi_id")
	@Column(name="tyyppi_id")
	private int tyyppiId;
	

	public Kysymys() {
	super();
	}
	
	public Kysymys(int id) {
		this.id = id;
	}
	
	public Kysymys(int id, String nimi) {
		this.id = id;
		this.nimi = nimi;
	}
	
	public String getVastausvaihtoehdot() {
		return vastausvaihtoehdot;
	}

	public void setVastausvaihtoehdot(String vastausvaihtoehdot) {
		this.vastausvaihtoehdot = vastausvaihtoehdot;
	}


	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}
	
	public void addToList(Vastaus v) {
		vastaukset.add(v);
	}


	public String getNimi() {
		return nimi;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public Kysely getKysely() {
		return kysely;
	}


	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}
	
	public int getTyyppiId() {
		return tyyppiId;
	}

	public void setTyyppiId(int tyyppiId) {
		this.tyyppiId = tyyppiId;
	}
	
	public int getKyselyid() {
		return kyselyid;
	}

	public void setKyselyid(int kyselyid) {
		this.kyselyid = kyselyid;
	}

	public String toString() {
		return "kysymys: "+ this.getNimi();
	}
	
	
}
