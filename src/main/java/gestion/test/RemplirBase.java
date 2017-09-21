package gestion.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import gestion.dao.ClientDao;
import gestion.dao.CommandeDao;
import gestion.dao.DestinataireDao;
import gestion.dao.EmployeDao;
import gestion.dao.JeuVideoDao;
import gestion.dao.LoginDao;
import gestion.model.Adresse;
import gestion.model.Client;
import gestion.model.Commande;
import gestion.model.Destinataire;
import gestion.model.Employe;
import gestion.model.JeuVideo;
import gestion.model.Login;

public class RemplirBase {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginDao loginDao = (LoginDao) context.getBean("loginDaoJpa");
		ClientDao clientDao = (ClientDao) context.getBean("clientDaoJpa");
		CommandeDao commandeDao = (CommandeDao) context.getBean("commandeDaoJpa");
		EmployeDao employeDao = (EmployeDao) context.getBean("employeDaoJpa");
		JeuVideoDao jeuVideoDao = (JeuVideoDao) context.getBean("jeuVideoDaoJpa");
		DestinataireDao destinataireDao = (DestinataireDao) context.getBean("destinataireDaoJpa");

		Login l = new Login("root", "root");
		Login l1 = new Login("admin", "admin");
		Login l2 = new Login("pass", "pass");
		Login l3 = new Login("password", "password");
		Login l4 = new Login("employe1", "job1");
		Login l5 = new Login("employe2", "job2");
		Login l6 = new Login("employe3", "job3");

		loginDao.create(l);
		loginDao.create(l1);
		loginDao.create(l2);
		loginDao.create(l3);
		loginDao.create(l4);
		loginDao.create(l5);
		loginDao.create(l6);

		Client c = new Client("jamal", "bousfiha", "bousfihajamal@hotmail.com", l, 663044384, null, null);
		Client c1 = new Client("reda", "belhadj", "reda.belhadj@gmail.com", l1, 658142578, null, null);
		Client c2 = new Client("jean-françois", "huchard", "jfpourajc@gmail.com", l2, 645145784, null, null);
		Client c3 = new Client("aboubacar", "toure", "aboubacar.toure91@gmail.com", l3, 654747894, null, null);
		clientDao.create(c);
		clientDao.create(c1);
		clientDao.create(c2);
		clientDao.create(c3);

		Commande co = new Commande("CB", 100);
		Commande co1 = new Commande("espece", 150F);
		Commande co2 = new Commande("Mastercard", 75.5F);
		commandeDao.create(co);
		commandeDao.create(co1);
		commandeDao.create(co2);

		Employe e = new Employe("jama", "bousfih", "bousfihajamal@hotmai.com", l4,
				new Adresse("surprise", "93390", "clichy-sous-bois"));
		Employe e1 = new Employe("Red", "belhad", "reda.belhadj@gmai.com", l5, null);
		Employe e2 = new Employe("aboubacar", "toure", "aboubacar.toure91@gmail.com", l6, null);
		employeDao.create(e);
		employeDao.create(e1);
		employeDao.create(e2);

		JeuVideo j = new JeuVideo(45F, 50, true, "", "course", "switch", "mario kart 8 deluxe");
		JeuVideo j1 = new JeuVideo(70F, 20, true, "", "fps", "ps4", "call of duty black ops 3");
		JeuVideo j2 = new JeuVideo(70F, 25, true, "", "fps", "xbox one", "call of duty black ops 3");
		JeuVideo j3 = new JeuVideo(65.50F, 20, true, "", "fps", "pc", "call of duty black ops 3");
		jeuVideoDao.create(j);
		jeuVideoDao.create(j1);
		jeuVideoDao.create(j2);
		jeuVideoDao.create(j3);

		Destinataire d = new Destinataire("jamal", "bousfiha", "bousfihajamal@hotmail.com", null, 663044384,
				new Adresse("surprise", "93390", "clichy-sous-bois"), co);
		Destinataire d1 = new Destinataire("reda", "belhadj", "reda.belhadj@gmail.com", null, 658142578,
				new Adresse("rougemont", "75009", "paris"), co1);
		destinataireDao.create(d1);
		destinataireDao.create(d);

		context.close();

	}

}
