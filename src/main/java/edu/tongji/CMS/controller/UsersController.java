package edu.tongji.CMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.CMS.dao.UsersDao;
import edu.tongji.CMS.domain.Services;
import edu.tongji.CMS.domain.Users;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersDao usersDao;

	@GetMapping(value = "")
	public ModelAndView usersList() {
		Iterable<Users> users = usersDao.findAll();
		return new ModelAndView("users/dashboard", "users", users);
	}

	@GetMapping("/{id}")
	public ModelAndView viewPersonInfo(@PathVariable("id") long id) {
		Users user = usersDao.findOne(id);
		return new ModelAndView("users/details", "user", user);
	}
	
	@GetMapping("/modify/{id}")
	public ModelAndView serviceCreateForm(@ModelAttribute Services services) {
		return new ModelAndView("users/modify");
	}
}
