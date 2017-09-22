package gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion.dao.AdresseDao;
import gestion.dao.ClientDao;
import gestion.dao.LoginDao;
import gestion.model.Client;
import gestion.model.Adresse;
import gestion.model.Login;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cli", headers = "Accept=application/json")
public class ClientController {
	// @Autowired
	// ServiceCommande serviceCommande;
	@Autowired
	ClientDao clientDao;
	@Autowired
	AdresseDao adresseDao;
	@Autowired
	LoginDao loginDao;

	// Affiche tous les clients
	// http://localhost:8080/gestion_jeux/mvc/cli/clients
	@GetMapping(value = "/clients")
	public List<Client> findAll() {
		return clientDao.findAll();
	}

	// http://localhost:8080/gestion_jeux/mvc/cli/client/id/10
	// Affiche le client sélectionné avec l'id en GET
	@GetMapping(value = "/client/id/{id}")
	public Client findClientById(@PathVariable("id") Long id) {
		return clientDao.find(id);
	}

	// http://localhost:8080/gestion_jeux/mvc/cli/client/nom/bousfiha
	// Affiche le client sélectionné avec le nom en GET
	@GetMapping(value = "/client/nom/{nom}")
	public Client findClientByName(@PathVariable("nom") String nom) {
		return clientDao.findByName(nom);
	}


	@GetMapping(value = "/client/tel/{tel}")
	public Client findClientByTel(@PathVariable("tel") int tel) {
		return clientDao.findByTel(tel);
	}

	@PostMapping(value = "/client")
	public void creerClient(@RequestBody Client client) {
		clientDao.create(client);
	}
	
	@GetMapping(value = "/addresses")
	public List<Adresse> findAll1() {
		return adresseDao.findAll();
	}
	
	@PostMapping(value = "/adresse")
	public void creerAdresse(@RequestBody Adresse adresse) {
		adresseDao.create(adresse);
	}
	

	@PostMapping(value = "/login")
	public void creerLogin(@RequestBody Login login) {
		loginDao.create(login);
	}
	
	@PostMapping(value="/create")
	public void creerCompte(@RequestBody Client client , Adresse adresse, Login login) {
		clientDao.create(client);
		adresseDao.create(adresse);
		loginDao.create(login);
		client.setAdresse(adresse);
		client.setLogin(login);
		clientDao.update(client);
	}


	

}
