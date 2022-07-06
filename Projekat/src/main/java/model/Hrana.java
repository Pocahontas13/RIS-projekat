package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hrana database table.
 * 
 */
@Entity
@NamedQuery(name="Hrana.findAll", query="SELECT h FROM Hrana h")
public class Hrana implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double cena;

	private int kolicina;

	private String naziv;

	//bi-directional many-to-one association to Kategorijahrane
	@ManyToOne
	@JoinColumn(name="idKat")
	private Kategorijahrane kategorijahrane;

	//bi-directional many-to-one association to Kolicinahrane
	@OneToMany(mappedBy="hrana", fetch=FetchType.EAGER)
	private List<Kolicinahrane> kolicinahranes;

	public Hrana() {
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

	public Kategorijahrane getKategorijahrane() {
		return this.kategorijahrane;
	}

	public void setKategorijahrane(Kategorijahrane kategorijahrane) {
		this.kategorijahrane = kategorijahrane;
	}

	public List<Kolicinahrane> getKolicinahranes() {
		return this.kolicinahranes;
	}

	public void setKolicinahranes(List<Kolicinahrane> kolicinahranes) {
		this.kolicinahranes = kolicinahranes;
	}

	public Kolicinahrane addKolicinahrane(Kolicinahrane kolicinahrane) {
		getKolicinahranes().add(kolicinahrane);
		kolicinahrane.setHrana(this);

		return kolicinahrane;
	}

	public Kolicinahrane removeKolicinahrane(Kolicinahrane kolicinahrane) {
		getKolicinahranes().remove(kolicinahrane);
		kolicinahrane.setHrana(null);

		return kolicinahrane;
	}

}