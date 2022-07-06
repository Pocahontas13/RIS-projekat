package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the konobar database table.
 * 
 */
@Entity
@NamedQuery(name="Konobar.findAll", query="SELECT k FROM Konobar k")
public class Konobar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String ime;

	private int sifra;

	//bi-directional many-to-one association to Porudzbina
	@OneToMany(mappedBy="konobar", fetch=FetchType.EAGER)
	private List<Porudzbina> porudzbinas;

	public Konobar() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getSifra() {
		return this.sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public List<Porudzbina> getPorudzbinas() {
		return this.porudzbinas;
	}

	public void setPorudzbinas(List<Porudzbina> porudzbinas) {
		this.porudzbinas = porudzbinas;
	}

	public Porudzbina addPorudzbina(Porudzbina porudzbina) {
		getPorudzbinas().add(porudzbina);
		porudzbina.setKonobar(this);

		return porudzbina;
	}

	public Porudzbina removePorudzbina(Porudzbina porudzbina) {
		getPorudzbinas().remove(porudzbina);
		porudzbina.setKonobar(null);

		return porudzbina;
	}

}