package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the kategorijahrane database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorijahrane.findAll", query="SELECT k FROM Kategorijahrane k")
public class Kategorijahrane implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String naziv;

	//bi-directional many-to-one association to Hrana
	@OneToMany(mappedBy="kategorijahrane", fetch=FetchType.EAGER)
	private List<Hrana> hranas;

	public Kategorijahrane() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Hrana> getHranas() {
		return this.hranas;
	}

	public void setHranas(List<Hrana> hranas) {
		this.hranas = hranas;
	}

	public Hrana addHrana(Hrana hrana) {
		getHranas().add(hrana);
		hrana.setKategorijahrane(this);

		return hrana;
	}

	public Hrana removeHrana(Hrana hrana) {
		getHranas().remove(hrana);
		hrana.setKategorijahrane(null);

		return hrana;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hranas, id, naziv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kategorijahrane other = (Kategorijahrane) obj;
		return Objects.equals(hranas, other.hranas) && id == other.id && Objects.equals(naziv, other.naziv);
	}

	
}