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

import gestion.model.JeuVideo;
//import gestion.service.ServiceGestionStock;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/pro", headers = "Accept=application/json")

public class ProduitController {
	/*
	 * @Autowired ServiceGestionStock serviceGestionStock;
	 */

	@Autowired
	JeuVideoDao jeuVideoDao;


	// affiche la liste des jeux
	// http://localhost:8080/gestion_jeux/mvc/produits/jeux
	@GetMapping(value = "/jeux")
	public List<JeuVideo> findAll() {
		return jeuVideoDao.findAll();
	}
	
	// a faire dans Angular
	 @GetMapping(value ="/Jeux/nom/{nom}")
		public JeuVideo findByNom(@PathVariable("nom") String nom) {
			return jeuVideoDao.findByNom(nom);
	 }
	 
	// a faire dans Angular
	 @GetMapping(value ="/Jeux/genre/{genre}")
		public JeuVideo findByGenre(@PathVariable("genre") String genre) {
			return jeuVideoDao.findByGenre(genre);
	 }
	 
	// a faire dans Angular
	 @GetMapping(value ="/Jeux/plate/{plateforme}")
		public JeuVideo findByPlateforme(@PathVariable("plateforme") String plateforme) {
			return jeuVideoDao.findByPlateforme(plateforme);
	 }
	 

	// permet la création d'un jeu
	// a faire dans Angular
	@PostMapping(value = "/jeu")
	public void creerJeu(@RequestBody JeuVideo jeuVideo) {
		jeuVideoDao.create(jeuVideo);
	}
	/*
	 * @PostMapping(value ="/jeuVideo") public void ajouterJeuVideo(@RequestBody
	 * JeuVideo jeuVideo){ commandeDao.ajouter(jeuVideo); }
	 * 
	 * @DeleteMapping(value ="/jeuVideo") public void
	 * supprimerJeuVideo(@RequestBody JeuVideo jeuVideo){ / a la commande du
	 * client / commandeDao.supprimer(jeuVideo); }
	 * 
	 * @PostMapping(value ="/jeuVideo") public void
	 * mettreAJourJeuVideo(@RequestBody JeuVideo jeuVideo) { / dans le stock /
	 * commandeDao.mettreAJour(jeuVideo); }
	 * 
	 * @PostMapping(value="/jeuVideo") public void
	 * verifierStockJeuVideo(@RequestBody JeuVideo jeuVideo) {
	 * commandeDao.verifierStock(jeuVideo);
	 */

}
