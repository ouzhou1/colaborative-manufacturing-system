package edu.tongji.CMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.CMS.dao.DemandsDao;
import edu.tongji.CMS.domain.Demands;
import edu.tongji.CMS.domain.Services;

@Controller
@RequestMapping("/demands")
public class DemandsController {

	@Autowired
	private DemandsDao demandsDao;

	@GetMapping(value = "")
	public ModelAndView servicesAllList() {
		Iterable<Demands> demands = demandsDao.findAll();
		return new ModelAndView("demands/dashboard", "demands", demands);
	}

	@GetMapping("/{id}")
	public Demands viewOrder(@PathVariable("id") long id) {
		Demands demands = demandsDao.findOne(id);
		return demands;
	}

	@GetMapping("/publish")
	public ModelAndView serviceCreateForm(@ModelAttribute Services services) {
		return new ModelAndView("demands/publish");
	}
}
