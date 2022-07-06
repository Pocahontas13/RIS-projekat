package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kolicinapica database table.
 * 
 */
@Entity
@NamedQuery(name="Kolicinapica.findAll", query="SELECT k FROM Kolicinapica k")
public class Kolicinapica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int kolicina;

	//bi-directional many-to-one association to Pice
	@ManyToOne
	@JoinColumn(name="idPice")
	private Pice pice;

	//bi-directional many-to-one association to Porudzbina
	@ManyToOne
	@JoinColumn(name="idPorudzbina")
	private Porudzbina porudzbina;

	public Kolicinapica() {
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

	public Pice getPice() {
		return this.pice;
	}

	public void setPice(Pice pice) {
		this.pice = pice;
	}

	public Porudzbina getPorudzbina() {
		return this.porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}

}