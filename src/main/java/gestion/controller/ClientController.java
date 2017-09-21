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

import gestion.dao.ClientDao;
import gestion.dao.CommandeDao;
import gestion.dao.DestinataireDao;
import gestion.dao.EmployeDao;
import gestion.dao.JeuVideoDao;
import gestion.dao.LoginDao;
import gestion.model.Client;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cli", headers = "Accept=application/json")
public class ClientController {
	// @Autowired
	// ServiceCommande serviceCommande;
	@Autowired
	ClientDao clientDao;
	@Autowired
	CommandeDao commandeDao;
	@Autowired
	EmployeDao employeDao;
	@Autowired
	DestinataireDao destinataireDao;
	@Autowired
	JeuVideoDao jeuVideoDao;
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

	// http://localhost:8080/gestion_jeux/mvc/cli/client/email/bousfihajamal@hotmail.com
	// Affiche le client sélectionné avec le mail en GET

	// @GetMapping(value = "/client/email/{mail}")
	// public Client findClientByMail(@PathVariable("mail") String email) {
	// return clientDao.findByMail(email);
	// }

	@GetMapping(value = "/client/tel/{tel}")
	public Client findClientByTel(@PathVariable("tel") int tel) {
		return clientDao.findByTel(tel);
	}

	// Permet la création d'un client
	// http://localhost:8080/gestion_jeux/mvc/cli/client
	/*
	 * json à insérer pour test {"prenom":"aboubacar", "nom":"toure",
	 * "mail":"aboubacar.toure91@gmail.com", "telephone":654747894, "adresse":null}
	 */
	@PostMapping(value = "/client")
	public void creerClient(@RequestBody Client client) {
		clientDao.create(client);
	}
	/* @GetMapping(value ="/client")
	public void seConnecterClient(@RequestBody Client client) {
	 clientDao.seConnecter(client); 
	}
	
	@PutMapping(value ="/client")
	public void gererCoordonnesClient(@RequestBody Client client) {
	 clientDao.gererCoordonnes(client);
	 }
	
	@PutMapping(value="/client")
	public void miseAJourHistoriqueClient(@RequestBody Client client) {
	 commandeDao.miseAJourHistorique(client);
	} */

}
