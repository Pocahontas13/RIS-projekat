package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kolicinahrane database table.
 * 
 */
@Entity
@NamedQuery(name="Kolicinahrane.findAll", query="SELECT k FROM Kolicinahrane k")
public class Kolicinahrane implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int kolicina;

	//bi-directional many-to-one association to Hrana
	@ManyToOne
	@JoinColumn(name="idHrana")
	private Hrana hrana;

	//bi-directional many-to-one association to Porudzbina
	@ManyToOne
	@JoinColumn(name="idPorudzbina")
	private Porudzbina porudzbina;

	public Kolicinahrane() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public Hrana getHrana() {
		return this.hrana;
	}

	public void setHrana(Hrana hrana) {
		this.hrana = hrana;
	}

	public Porudzbina getPorudzbina() {
		return this.porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}

}