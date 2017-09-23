package gestion.controller.data;

import java.io.Serializable;

import gestion.model.Adresse;
import gestion.model.Client;
import gestion.model.Login;


public class Compte implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5446497615246014060L;
	

	private Client client;

	private Adresse adresse;

	private Login login;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	@Override
	public String toString() {
		return "Compte [client=" + client + ", adresse=" + adresse + ", login=" + login + "]";
	}
	public Compte() {
		super();
	}
	public Compte(Client client, Adresse adresse, Login login) {
		super();
		this.client = client;
		this.adresse = adresse;
		this.login = login;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Compte other = (Compte) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	
	

}
