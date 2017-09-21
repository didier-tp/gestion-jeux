package gestion.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Client")
public class Client extends Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8660817046707436727L;

	// idPersonne hérité --> pas besoin de idClient
	// private Long idClient;

	@Column(length = 20)
	private int telephone;

	@Column
	private Adresse adresse;

	@OneToMany(mappedBy = "client")
	@JsonIgnore
	private List<Commande> commandes;

	// constructeur par défaut
	public Client() {
		super();
	}

	public Client(String prenom, String nom, String mail, Login login, int telephone, Adresse adresse,
			List<Commande> commandes) {
		super(prenom, nom, mail, login);
		this.telephone = telephone;
		this.adresse = adresse;
		this.commandes = commandes;
	}

	// constructeur avec login détaillé
	public Client(String prenom, String nom, String mail, String login, String password, int telephone, Adresse adresse,
			List<Commande> commandes) {
		super(prenom, nom, mail, new Login(login, password));
		this.telephone = telephone;
		this.adresse = adresse;
		this.commandes = commandes;
	}

	// constructeur avec login et adresse détaillés
	public Client(String prenom, String nom, String mail, String login, String password, int telephone, String rue,
			String codePostal, String ville, List<Commande> commandes) {
		super(prenom, nom, mail, new Login(login, password));
		this.telephone = telephone;
		this.adresse = new Adresse(rue, codePostal, ville);
		this.commandes = commandes;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((commandes == null) ? 0 : commandes.hashCode());
		result = prime * result + telephone;
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
		Client other = (Client) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (commandes == null) {
			if (other.commandes != null)
				return false;
		} else if (!commandes.equals(other.commandes))
			return false;
		if (telephone != other.telephone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [telephone=" + telephone + ", adresse=" + adresse + ", commandes=" + commandes + "]";
	}

}
