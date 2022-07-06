package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the kategorijapica database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorijapica.findAll", query="SELECT k FROM Kategorijapica k")
public class Kategorijapica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String naziv;

	//bi-directional many-to-one association to Pice
	@OneToMany(mappedBy="kategorijapica", fetch=FetchType.EAGER)
	private List<Pice> pices;

	public Kategorijapica() {
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

	public List<Pice> getPices() {
		return this.pices;
	}

	public void setPices(List<Pice> pices) {
		this.pices = pices;
	}

	public Pice addPice(Pice pice) {
		getPices().add(pice);
		pice.setKategorijapica(this);

		return pice;
	}

	public Pice removePice(Pice pice) {
		getPices().remove(pice);
		pice.setKategorijapica(null);

		return pice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, naziv, pices);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kategorijapica other = (Kategorijapica) obj;
		return id == other.id && Objects.equals(naziv, other.naziv) && Objects.equals(pices, other.pices);
	}
	
	

}