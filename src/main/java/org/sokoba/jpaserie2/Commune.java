package org.sokoba.jpaserie2;
import java.io.Serializable;
import javax.persistence.*;

@Entity(name="Commune")
@Table(name="communes")
public class Commune implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commune_id;
    
	@Column(name="nom_commune")
	private String nom;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	//@JoinColumn(name="departement_id",referencedColumnName="id")
	//@JoinColumn(name="departement_id")
	private Departement departement;
	
	@Column(name="code_postal")
	private String codePostal;
	
    @OneToOne(cascade= {CascadeType.ALL})
	//@JoinColumn(name="maire_id",referencedColumnName="id")
    private Maire maire ;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Commune() {
		super();
	}

	public Commune(String nom, String codePostal) {
		super();
		this.nom = nom;
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Commune [id=" + commune_id + ", nom=" + nom + ", codePostal=" + codePostal + "]";
	}
	
	
	
	
}
