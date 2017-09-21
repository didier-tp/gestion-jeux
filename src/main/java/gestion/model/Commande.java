package gestion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commande implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8487464032349281387L;
	@Id
	@GeneratedValue
	private long idCommande;
	@Column
	private String moyenPaiement;
	@Column
	private float montant;

	@OneToOne
	@JsonIgnore
	public Destinataire destinataire;

	@ManyToOne
	@JoinColumn(name = "commandes")
	@JsonIgnore
	private Client client;

	@ManyToOne
	@JoinColumn(name = "commandesL")
	@JsonIgnore
	public LigneCommande ligneCommande;

	public Commande() {
		super();
	}

	public Commande(String moyenPaiement, float montant) {
		super();
		this.moyenPaiement = moyenPaiement;
		this.montant = montant;
	}

	public Destinataire getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Destinataire destinataire) {
		this.destinataire = destinataire;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	public long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}

	public String getMoyenPaiement() {
		return moyenPaiement;
	}

	public void setMoyenPaiement(String moyenPaiement) {
		this.moyenPaiement = moyenPaiement;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", moyenPaiement=" + moyenPaiement + ", montant=" + montant + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCommande ^ (idCommande >>> 32));
		result = prime * result + Float.floatToIntBits(montant);
		result = prime * result + ((moyenPaiement == null) ? 0 : moyenPaiement.hashCode());
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
		Commande other = (Commande) obj;
		if (idCommande != other.idCommande)
			return false;
		if (Float.floatToIntBits(montant) != Float.floatToIntBits(other.montant))
			return false;
		if (moyenPaiement == null) {
			if (other.moyenPaiement != null)
				return false;
		} else if (!moyenPaiement.equals(other.moyenPaiement))
			return false;
		return true;
	}

}
