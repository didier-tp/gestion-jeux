package gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion.dao.ClientDao;
import gestion.dao.CommandeDao;
import gestion.dao.DestinataireDao;
import gestion.dao.EmployeDao;
import gestion.dao.JeuVideoDao;
import gestion.dao.LoginDao;
import gestion.model.Commande;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/com", headers = "Accept=application/json")

public class CommandeController {

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

	@GetMapping(value = "/commande")
	public List<Commande> findAll() {
		return commandeDao.findAll();
	}
	/*
	 * @PostMapping(value ="/commande") public void
	 * remplirPanierCommande(@RequestBody Commande commande){
	 * commandeDao.remplirPanierCommande(commande); }
	 * 
	 * @PutMapping(value="/commande") public void
	 * CalculerPanierCommande(@RequestBody Commande commande) {
	 * commandeDao.CalculerPanier(commande); }
	 * 
	 * @DeleteMapping(value="/commande") public void
	 * supprimerProduitCommande(@RequestBody Commande commande) {
	 * commandeDao.supprimerProduit(commande); }
	 * 
	 * @OptionMapping(value="/commande") public void
	 * validerPaiementCommande(@RequestBody Commande commande) {
	 * commandeDao.validerPaiement(commande);
	 * 
	 * }
	 */

}
