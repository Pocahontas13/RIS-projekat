package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the porudzbina database table.
 * 
 */
@Entity
@NamedQuery(name="Porudzbina.findAll", query="SELECT p FROM Porudzbina p")
public class Porudzbina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int idStola;

	//bi-directional many-to-one association to Kolicinahrane
	@OneToMany(mappedBy="porudzbina")
	private List<Kolicinahrane> kolicinahranes;

	//bi-directional many-to-one association to Kolicinapica
	@OneToMany(mappedBy="porudzbina")
	private List<Kolicinapica> kolicinapicas;

	//bi-directional many-to-one association to Konobar
	@ManyToOne
	@JoinColumn(name="idKonobar")
	private Konobar konobar;

	//bi-directional many-to-one association to Racun
	@ManyToOne
	@JoinColumn(name="idRacun")
	private Racun racun;

	//bi-directional many-to-one association to Sto
	@OneToMany(mappedBy="porudzbina")
	private List<Sto> stos;

	public Porudzbina() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdStola() {
		return this.idStola;
	}

	public void setIdStola(int idStola) {
		this.idStola = idStola;
	}

	public List<Kolicinahrane> getKolicinahranes() {
		return this.kolicinahranes;
	}

	public void setKolicinahranes(List<Kolicinahrane> kolicinahranes) {
		this.kolicinahranes = kolicinahranes;
	}

	public Kolicinahrane addKolicinahrane(Kolicinahrane kolicinahrane) {
		getKolicinahranes().add(kolicinahrane);
		kolicinahrane.setPorudzbina(this);

		return kolicinahrane;
	}

	public Kolicinahrane removeKolicinahrane(Kolicinahrane kolicinahrane) {
		getKolicinahranes().remove(kolicinahrane);
		kolicinahrane.setPorudzbina(null);

		return kolicinahrane;
	}

	public List<Kolicinapica> getKolicinapicas() {
		return this.kolicinapicas;
	}

	public void setKolicinapicas(List<Kolicinapica> kolicinapicas) {
		this.kolicinapicas = kolicinapicas;
	}

	public Kolicinapica addKolicinapica(Kolicinapica kolicinapica) {
		getKolicinapicas().add(kolicinapica);
		kolicinapica.setPorudzbina(this);

		return kolicinapica;
	}

	public Kolicinapica removeKolicinapica(Kolicinapica kolicinapica) {
		getKolicinapicas().remove(kolicinapica);
		kolicinapica.setPorudzbina(null);

		return kolicinapica;
	}

	public Konobar getKonobar() {
		return this.konobar;
	}

	public void setKonobar(Konobar konobar) {
		this.konobar = konobar;
	}

	public Racun getRacun() {
		return this.racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

	public List<Sto> getStos() {
		return this.stos;
	}

	public void setStos(List<Sto> stos) {
		this.stos = stos;
	}

	public Sto addSto(Sto sto) {
		getStos().add(sto);
		sto.setPorudzbina(this);

		return sto;
	}

	public Sto removeSto(Sto sto) {
		getStos().remove(sto);
		sto.setPorudzbina(null);

		return sto;
	}

}