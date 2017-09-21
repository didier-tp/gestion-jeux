package gestion.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import gestion.dao.LoginDao;
import gestion.model.Login;

public class TestLoginDao {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginDao loginDao = (LoginDao) context.getBean("loginDaoJpa");
		Login l = new Login("admino", "admino");
		Login l1 = new Login();
		
		loginDao.create(l);
		
		l.setMotDePasse("root");
		loginDao.update(l);
		
		l1=(Login)loginDao.findByLogin("admin");
		System.out.println(l1.getIdLogin()+ "/"+l1.getLogin()+ "/"+l1.getMotDePasse());
		
		loginDao.delete(l1);	
		context.close();
	}

}
