package gestion.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Produit")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeProduit", discriminatorType = DiscriminatorType.STRING)
public abstract class Produit {

	@Id
	@GeneratedValue
	private Long idProduit;

	public Long getIdProduit() {
		return idProduit;
	}

	@Column
	private float prix;
	@Column
	private int stock;
	@Column
	public boolean disponibilite;
	@ManyToOne
	@JoinColumn(name = "produits")
	@JsonIgnore
	private LigneCommande ligneCommandeP;
	@Column
	private String descriptif;

	public Produit(float prix, int stock, boolean disponibilite, String descriptif) {
		super();
		this.prix = prix;
		this.stock = stock;
		this.disponibilite = disponibilite;
		this.descriptif = descriptif;
	}

	public Produit() {
		// TODO Auto-generated constructor stub
	}

	public LigneCommande getLigneCommandeP() {
		return ligneCommandeP;
	}

	public void setLigneCommandeP(LigneCommande ligneCommandeP) {
		this.ligneCommandeP = ligneCommandeP;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", prix=" + prix + ", stock=" + stock + ", disponibilite="
				+ disponibilite + ", ligneCommandeP=" + ligneCommandeP + ", descriptif=" + descriptif + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (disponibilite ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(prix);
		result = prime * result + stock;
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
		Produit other = (Produit) obj;
		if (disponibilite != other.disponibilite)
			return false;
		if (Float.floatToIntBits(prix) != Float.floatToIntBits(other.prix))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}

}
