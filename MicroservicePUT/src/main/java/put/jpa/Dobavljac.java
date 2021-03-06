package put.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dobavljac database table.
 * 
 */
@Entity
@NamedQuery(name="Dobavljac.findAll", query="SELECT d FROM Dobavljac d")
public class Dobavljac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String adresa;

	private String kontakt;

	private String naziv;

	//bi-directional many-to-one association to Porudzbina
	@OneToMany(mappedBy="dobavljacBean")
	private List<Porudzbina> porudzbinas;

	public Dobavljac() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getKontakt() {
		return this.kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Porudzbina> getPorudzbinas() {
		return this.porudzbinas;
	}

	public void setPorudzbinas(List<Porudzbina> porudzbinas) {
		this.porudzbinas = porudzbinas;
	}

	public Porudzbina addPorudzbina(Porudzbina porudzbina) {
		getPorudzbinas().add(porudzbina);
		porudzbina.setDobavljacBean(this);

		return porudzbina;
	}

	public Porudzbina removePorudzbina(Porudzbina porudzbina) {
		getPorudzbinas().remove(porudzbina);
		porudzbina.setDobavljacBean(null);

		return porudzbina;
	}

}