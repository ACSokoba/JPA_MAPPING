package org.sokoba.jpaserie2;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*; 


@Entity(name="Maire")
@Table( name="maires")
public class Maire implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maire_id;
    
    @Column(name="civilite")
    @Enumerated(EnumType.STRING)
	private Civility civilite;
    
    @Column(name="nom")
	private String nom;
    
    @Column(name="prenom")
	private String prenom;
    
    @Column(name="dateDeNaissance")
    @Temporal(TemporalType.DATE)
	private Date  dateDeNaissance;
    
    @OneToOne(mappedBy="maire")  
    private Commune commune ;
    


	public Civility getCivilite() {
		return civilite;
	}

	public void setCivilite(Civility civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Maire(Civility civilite, String nom, String prenom, Date dateDeNaissance) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
	}

	public Maire() {
		super();
	}

	@Override
	public String toString() {
		return "Maire [id=" + maire_id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateDeNaissance=" + dateDeNaissance + "]";
	}
    
    
}
