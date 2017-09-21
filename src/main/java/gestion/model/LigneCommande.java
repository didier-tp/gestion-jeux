package gestion.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LigneCommande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2494251931004827137L;
	@Id
	@GeneratedValue
	private Long idLigneCommande;
	@Column
	public int quantite;

	public Long getIdLigneCommande() {
		return idLigneCommande;
	}

	@OneToMany(mappedBy = "ligneCommandeP")
	@JsonIgnore
	public List<Produit> produits;
	@OneToMany(mappedBy = "ligneCommande")
	@JsonIgnore
	private List<Commande> commandesL;

	public LigneCommande() {
		super();
	}

	public LigneCommande(int quantite) {
		super();
		this.quantite = quantite;
	}

	public int getQuantite() {
		return quantite;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public List<Commande> getCommandesL() {
		return commandesL;
	}

	public void setCommandesL(List<Commande> commandesL) {
		this.commandesL = commandesL;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "LigneCommande [quantite=" + quantite + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantite;
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
		LigneCommande other = (LigneCommande) obj;
		if (quantite != other.quantite)
			return false;
		return true;
	}

}
