package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pice database table.
 * 
 */
@Entity
@NamedQuery(name="Pice.findAll", query="SELECT p FROM Pice p")
public class Pice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double cena;

	private int kolicina;

	private String naziv;

	//bi-directional many-to-one association to Kolicinapica
	@OneToMany(mappedBy="pice", fetch=FetchType.EAGER)
	private List<Kolicinapica> kolicinapicas;

	//bi-directional many-to-one association to Kategorijapica
	@ManyToOne
	@JoinColumn(name="idKat")
	private Kategorijapica kategorijapica;

	public Pice() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Kolicinapica> getKolicinapicas() {
		return this.kolicinapicas;
	}

	public void setKolicinapicas(List<Kolicinapica> kolicinapicas) {
		this.kolicinapicas = kolicinapicas;
	}

	public Kolicinapica addKolicinapica(Kolicinapica kolicinapica) {
		getKolicinapicas().add(kolicinapica);
		kolicinapica.setPice(this);

		return kolicinapica;
	}

	public Kolicinapica removeKolicinapica(Kolicinapica kolicinapica) {
		getKolicinapicas().remove(kolicinapica);
		kolicinapica.setPice(null);

		return kolicinapica;
	}

	public Kategorijapica getKategorijapica() {
		return this.kategorijapica;
	}

	public void setKategorijapica(Kategorijapica kategorijapica) {
		this.kategorijapica = kategorijapica;
	}

}