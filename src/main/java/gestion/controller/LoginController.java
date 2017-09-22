package gestion.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gestion.dao.LoginDao;

import gestion.model.Login;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/log", headers = "Accept=application/json")

public class LoginController {

	@Autowired
	LoginDao loginDao;
	
	@PostMapping(value = "/login")
	public void creerClient(@RequestBody Login login) {
		loginDao.create(login);
	}
}
