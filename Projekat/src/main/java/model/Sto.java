package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sto database table.
 * 
 */
@Entity
@NamedQuery(name="Sto.findAll", query="SELECT s FROM Sto s")
public class Sto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte slobodan;

	//bi-directional many-to-one association to Porudzbina
	@ManyToOne
	@JoinColumn(name="idPorudzbina")
	private Porudzbina porudzbina;

	public Sto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getSlobodan() {
		return this.slobodan;
	}

	public void setSlobodan(byte slobodan) {
		this.slobodan = slobodan;
	}

	public Porudzbina getPorudzbina() {
		return this.porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}

}