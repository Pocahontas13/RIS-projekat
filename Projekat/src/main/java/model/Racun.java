package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the racun database table.
 * 
 */
@Entity
@NamedQuery(name="Racun.findAll", query="SELECT r FROM Racun r")
public class Racun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int brojRacuna;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private byte gotovina;

	@Temporal(TemporalType.DATE)
	private Date idPorudzbine;

	private double iznos;

	private byte kartica;

	//bi-directional many-to-one association to Porudzbina
	@OneToMany(mappedBy="racun", fetch=FetchType.EAGER)
	private List<Porudzbina> porudzbinas;

	public Racun() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrojRacuna() {
		return this.brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public byte getGotovina() {
		return this.gotovina;
	}

	public void setGotovina(byte gotovina) {
		this.gotovina = gotovina;
	}

	public Date getIdPorudzbine() {
		return this.idPorudzbine;
	}

	public void setIdPorudzbine(Date idPorudzbine) {
		this.idPorudzbine = idPorudzbine;
	}

	public double getIznos() {
		return this.iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public byte getKartica() {
		return this.kartica;
	}

	public void setKartica(byte kartica) {
		this.kartica = kartica;
	}

	public List<Porudzbina> getPorudzbinas() {
		return this.porudzbinas;
	}

	public void setPorudzbinas(List<Porudzbina> porudzbinas) {
		this.porudzbinas = porudzbinas;
	}

	public Porudzbina addPorudzbina(Porudzbina porudzbina) {
		getPorudzbinas().add(porudzbina);
		porudzbina.setRacun(this);

		return porudzbina;
	}

	public Porudzbina removePorudzbina(Porudzbina porudzbina) {
		getPorudzbinas().remove(porudzbina);
		porudzbina.setRacun(null);

		return porudzbina;
	}

}