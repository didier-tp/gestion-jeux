package gestion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Destinataire")
public class Destinataire extends Personne implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5058036820315493963L;
	@Column
	private int telephone;
	@Column
	private Adresse adresse;

	@OneToOne
	@JsonIgnore
	public Commande commande;

	public Destinataire(String prenom, String nom, String mail, Login login, int telephone, Adresse adresse,
			Commande commande) {
		super(prenom, nom, mail, login);
		this.telephone = telephone;
		this.adresse = adresse;
		this.commande = commande;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Destinataire [telephone=" + telephone + ", adresse=" + adresse + ", commande=" + commande + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((commande == null) ? 0 : commande.hashCode());
		result = prime * result + telephone;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destinataire other = (Destinataire) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (commande == null) {
			if (other.commande != null)
				return false;
		} else if (!commande.equals(other.commande))
			return false;
		if (telephone != other.telephone)
			return false;
		return true;
	}

}
