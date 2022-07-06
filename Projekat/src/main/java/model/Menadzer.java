package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menadzer database table.
 * 
 */
@Entity
@NamedQuery(name="Menadzer.findAll", query="SELECT m FROM Menadzer m")
public class Menadzer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String ime;

	private int sifra;

	public Menadzer() {
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

}