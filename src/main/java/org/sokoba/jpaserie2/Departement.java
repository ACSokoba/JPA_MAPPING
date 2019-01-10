package org.sokoba.jpaserie2;
import static javax.persistence.Persistence.createEntityManagerFactory;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity(name="Departement")
@Table(	name="departements")
public class Departement implements Serializable {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departement_id;

	@Column(name="nom_departement")
	private String nom;

	@Column(name="code_departement")
	private String code;

	@OneToMany(mappedBy="departement",fetch=FetchType.LAZY)
	private Set<Commune> Communes = new HashSet<Commune>();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Departement() {
		super();
	}

	@Override
	public String toString() {
		return "Departement [id=" + departement_id + ", nom=" + nom + ", code=" + code + ", Communes=" + Communes + "]";
	}	


//	public int getNumberOfTown() {
//
//		Query query=entityManager.createNativeQuery( "SELECT commune FROM Commune commune where departement_id = this.code");
//		List<Commune> communes = query.getResultList();
//		for (Object c : communes) {
//			// chaque élément est de type NameBean
//			Commune commune = (Commune)c ;
//			this.Communes.add(commune) ;
//		}		
//		return this.Communes.size();
//	}

}
