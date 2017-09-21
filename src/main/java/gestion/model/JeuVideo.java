package gestion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Jeu")
public class JeuVideo extends Produit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4459944155263137619L;

	@Column
	private String genre;
	@Column
	private String plateforme;
	@Column
	private String nomJeu;

	public JeuVideo(float prix, int stock, boolean disponibilite, String descriptif) {
		super(prix, stock, disponibilite, descriptif);
	}

	public JeuVideo() {
		super();
	}

	public JeuVideo(float prix, int stock, boolean disponibilite, String descriptif, String genre, String plateforme,
			String nomJeu) {
		super(prix, stock, disponibilite, descriptif);
		this.genre = genre;
		this.plateforme = plateforme;
		this.nomJeu = nomJeu;

	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlateforme() {
		return plateforme;
	}

	public void setPlateforme(String plateforme) {
		this.plateforme = plateforme;
	}

	public String getNomJeu() {
		return nomJeu;
	}

	public void setNomJeu(String nomJeu) {
		this.nomJeu = nomJeu;
	}

	@Override
	public String toString() {
		return "JeuVideo [genre=" + genre + ", plateforme=" + plateforme + ", nomJeu=" + nomJeu + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());

		result = prime * result + ((nomJeu == null) ? 0 : nomJeu.hashCode());
		result = prime * result + ((plateforme == null) ? 0 : plateforme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JeuVideo other = (JeuVideo) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;

		if (nomJeu == null) {
			if (other.nomJeu != null)
				return false;
		} else if (!nomJeu.equals(other.nomJeu))
			return false;
		if (plateforme == null) {
			if (other.plateforme != null)
				return false;
		} else if (!plateforme.equals(other.plateforme))
			return false;
		return true;
	}

}
